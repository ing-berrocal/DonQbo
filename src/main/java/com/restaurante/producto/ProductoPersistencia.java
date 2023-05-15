/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import com.restaurante.model.PromocionProducto;
import com.restaurante.producto.promocion.PromocionEntity;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.transaction.Transactional;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class ProductoPersistencia implements ProductoRepositorio{
    
    @Inject
    private EntityManager entitiManager;

    @Override
    @Transactional
    public Producto agregarProducto(Producto any){
        String toString = UUID.randomUUID().toString().substring(0, 9);
        ProductoEntity entity = new ProductoEntity();
        entity.setCodigo(toString);
        entity.setUrlImagen(toString);
        entity.setNombre(any.nombre());
        entity.setDescripcion(any.descripcion());
        entity.setValor(any.valor());
        entity.setEsActivo(Boolean.TRUE);
        
        entitiManager.persist(entity);
        return Optional.of(entity).map(mapProducto).get();
    }

    @Override
    public List<Producto> getAllProducts(){        
        return entitiManager.createNamedQuery(ProductoEntity.FINDALL, ProductoEntity.class)          
                .getResultList().stream().map((e)-> new Producto(e.getId(), 
                        e.getCategoria() ,e.getCodigo(), e.getNombre(), 
                        e.getDescripcion(), e.getUrlImagen(), e.getValor(),
                        (
                                e.getItems().stream().map(mapPromocion).toList()
                        ))).toList();        
    }
    
    private static Function<ProductoEntity,Producto> mapProducto = (ProductoEntity e) ->
            new Producto(e.getId(), e.getCategoria() , e.getCodigo(), e.getNombre(), 
                        e.getDescripcion(), e.getUrlImagen(), e.getValor(),
                        null
            );
    
    private Function<PromocionEntity,PromocionProducto> mapPromocion = (PromocionEntity e) ->
            new PromocionProducto(e.getId(),e.getNombre(),e.getMinItems(),e.getMaxItems(),
            //e.getPromocionProductos().stream().map(mapProducto).toList()
            getNamedQuery(e.getId()).stream().map(mapProducto).toList()
            );

    private List<ProductoEntity> getNamedQuery(Long promocionId){
        return entitiManager.createNamedQuery("selectAuthorEntities")
                .setParameter(1, promocionId)
                .setFlushMode(FlushModeType.AUTO)
                .getResultList();
    }
    
    @Override
    public Optional<Producto> getProductoById(long Id) {
        return Optional.of(entitiManager.find(ProductoEntity.class, Id)).map((e)-> new Producto(e.getId(), 
                        e.getCategoria() ,e.getCodigo(), e.getNombre(), 
                        e.getDescripcion(), e.getUrlImagen(), e.getValor(),
                        (e.getItems().stream().map(mapPromocion).toList())
                        
        ));
    }
}
