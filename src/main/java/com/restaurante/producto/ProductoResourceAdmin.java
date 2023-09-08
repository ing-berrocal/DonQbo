/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Product;
import com.restaurante.model.ProductoRequest;
import com.restaurante.util.Respuesta;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author DELL
 */
@Path("/admin/producto")
@RolesAllowed("admin")
public class ProductoResourceAdmin {

    @Inject
    ProductoUseCase productoUseCase;

    @GET
    public Respuesta<List<Product>> getProducts() {
        long executionStart = System.currentTimeMillis();
        List<Product> allProductos = this.productoUseCase.getProductos();
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return Respuesta.getInstance(allProductos);
    }

    @GET
    @Path(value = "/by-id/{id}")
    public Respuesta<Product> getProductById(@PathParam("id") Long id) {
        long executionStart = System.currentTimeMillis();
        Optional<Product> producto = this.productoUseCase.getProductoById(id);
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return producto.map(Respuesta::getInstance).get();
    }

    @POST
    public Respuesta<Product> agregarProducto(
            @Context SecurityContext sec,
            ProductoRequest request) {

        long executionStart = System.currentTimeMillis();
        Product agregarProducto = request.toProduct();
        Product productoAgregado = productoUseCase.agregarProducto(agregarProducto);
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);        
        return Respuesta.getInstance(productoAgregado);
    }

    @PUT
    @Path(value = "/by-id/{id}")
    public Respuesta<Product> editarProducto(@PathParam("id") Long id,
            @Context SecurityContext sec, ProductoRequest request) {

        long executionStart = System.currentTimeMillis();
        Product product = request.toProduct();
        product.setId(id);
        Product editarProducto = productoUseCase.editarProducto(product);

        Optional<Product> productoById = productoUseCase.getProductoById(id);

        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return Respuesta.getInstance(editarProducto);
    }
}
