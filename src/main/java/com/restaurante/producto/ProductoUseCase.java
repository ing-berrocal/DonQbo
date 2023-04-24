/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class ProductoUseCase {

    ProductoUseCase(com.restaurante.producto.ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    private final ProductoRepositorio productoRepositorio;
    
    public List<Producto> getAllProductos(){
        return this.productoRepositorio.getAllProducts();
    }
    
    void agregarProducto(Producto producto) {
        this.productoRepositorio.agregarProducto(producto);
    }
    
}
