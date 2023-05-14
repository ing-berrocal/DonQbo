/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import com.restaurante.model.PromocionProducto;
import com.restaurante.producto.promocion.PromocionEntity;
import java.util.List;
import java.util.function.Function;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class ProductoPersistencia implements ProductoRepositorio{
    
    @Inject
    private EntityManager entitiManager;

    @Override
    public Producto agregarProducto(Producto any){
        return null;
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
    
    private static Function<PromocionEntity,PromocionProducto> mapPromocion = (PromocionEntity e) ->
            new PromocionProducto(e.getId(),e.getNombre(),e.getMinItems(),e.getMaxItems(),
            e.getProductos().stream().map(mapProducto).toList());
}
