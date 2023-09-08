/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Product;
import com.restaurante.model.PromocionProducto;
import com.restaurante.producto.promocion.PromocionEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class ProductoPersistencia implements ProductoRepositorio {

        @Inject
        private EntityManager entityManager;

        @Override
        @Transactional
        public Product agregarProducto(Product any) {

                String toString = UUID.randomUUID().toString().substring(0, 9);
                ProductoEntity entity = new ProductoEntity();                
                productToEntity(any, entity);
                entity.setCodigo(toString);
                try {
                        Optional<ProductoEntity> ofNullable = Optional.ofNullable(
                                        entityManager.createNamedQuery(ProductoEntity.FINDNAME, ProductoEntity.class)
                                                        .setParameter("nombre", any.getNombre())
                                                        .getSingleResult());

                        if (ofNullable.isPresent()) {
                                throw new RuntimeException("Se registro un producto con el nombre");
                        }

                } catch (NoResultException e) {
                        entityManager.persist(entity);
                        entityManager.flush();
                        any = mapToProduct.apply(entity);
                        
                }
                return any;
        }

        @Override
        public List<Product> getAllProducts() {
                return entityManager.createNamedQuery(ProductoEntity.FINDALL, ProductoEntity.class)
                                .getResultList().stream().map((e) -> new Product(e.getId(),
                                                e.getCategoria(), e.getCodigo(), e.getNombre(),
                                                e.getDescripcion(), e.getUrlImagen(), e.getValor(),
                                                (e.getItems().stream().map(mapPromocion).toList()), Boolean.TRUE))
                                .toList();
        }

        private static Function<ProductoEntity, Product> mapToProduct = (ProductoEntity e) -> new Product(e.getId(),
                        e.getCategoria(), e.getCodigo(), e.getNombre(),
                        e.getDescripcion(), e.getUrlImagen(), e.getValor(),
                        null, e.getEsActivo());

        private Function<PromocionEntity, PromocionProducto> mapPromocion = (
                        PromocionEntity e) -> new PromocionProducto(e.getId(), e.getNombre(), e.getMinItems(),
                                        e.getMaxItems(),
                                        // e.getPromocionProductos().stream().map(mapProducto).toList()
                                        getNamedQuery(e.getId()).stream().map(mapToProduct).toList());

        private List<ProductoEntity> getNamedQuery(Long promocionId) {
                return entityManager.createNamedQuery("selectAuthorEntities", ProductoEntity.class)
                                .setParameter(1, promocionId)
                                .setFlushMode(FlushModeType.AUTO)
                                .getResultList();
        }

        @Override
        public Optional<Product> getProductoById(long Id) {
                return Optional.of(entityManager.find(ProductoEntity.class, Id)).map((e) -> new Product(e.getId(),
                                e.getCategoria(), e.getCodigo(), e.getNombre(),
                                e.getDescripcion(), e.getUrlImagen(), e.getValor(),
                                (e.getItems().stream().map(mapPromocion).toList()), Boolean.TRUE));
        }

        @Override
        @Transactional
        public void editProduct(Product any) {

                ProductoEntity find = entityManager.find(ProductoEntity.class, any.getId());
                productToEntity(any, find);
                entityManager.persist(find);
                entityManager.flush();
        }

        static void productToEntity(Product product, ProductoEntity productEntity) {
                productEntity.setCodigo(product.getCodigo());
                productEntity.setUrlImagen(product.getUrlImagen());
                productEntity.setNombre(product.getNombre());
                productEntity.setDescripcion(product.getDescripcion());
                productEntity.setValor(product.getValor());
                productEntity.setEsActivo(product.getEstaActivo());
                productEntity.setCategoria(product.getCategoria());
        }
}