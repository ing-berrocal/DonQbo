/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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
    
    public Map<String,List<Producto>> getAllProductos(){
        return this.productoRepositorio.getAllProducts()
                .stream()
                .collect(Collectors.groupingBy(Producto::categoria));
    }
    
    public List<Producto> getProductos(){
        return this.productoRepositorio.getAllProducts();
    }
    
    public Optional<Producto> getProductoById(long Id){
        return this.productoRepositorio.getProductoById(Id);
    }
    
    Producto agregarProducto(Producto producto) {
        return this.productoRepositorio.agregarProducto(producto);
    }
    
}
