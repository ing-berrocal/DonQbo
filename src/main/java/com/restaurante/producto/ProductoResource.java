/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author DELL
 */
@Path("/producto")
public class ProductoResource {
    
    @Inject
    ProductoUseCase productoUseCase;
    
    @GET
    public List<Producto> getAllProducts(){
        long executionStart = System.currentTimeMillis();
        List<Producto> allProductos = this.productoUseCase.getAllProductos();
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return allProductos;
    }
}
