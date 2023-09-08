/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Product;
import java.util.List;
import java.util.Map;
import javax.annotation.security.PermitAll;
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
    @PermitAll
    public Map<String, List<Product>> getAllProducts() {
        long executionStart = System.currentTimeMillis();
        Map<String, List<Product>> allProductos = this.productoUseCase.getAllProductos();
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return allProductos;
    }
}
