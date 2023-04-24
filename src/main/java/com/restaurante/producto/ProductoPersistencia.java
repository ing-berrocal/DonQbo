/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import java.util.Collections;
import java.util.List;
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
    public void agregarProducto(Producto any){
    
    }

    @Override
    public List<Producto> getAllProducts(){        
        return entitiManager.createNamedQuery(ProductoEntity.FINDALL, ProductoEntity.class)
                .getResultStream().map((e)->Producto.newInstance(e.getId(), e.getCodigo(), e.getNombre(), 
                        e.getDescripcion(), e.getUrlImagen(), e.getValor())).toList();        
    }
    
}
