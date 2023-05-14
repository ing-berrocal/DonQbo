/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import com.restaurante.model.ProductoRequest;
import com.restaurante.respuesta.ProductoRespuesta;
import java.util.List;
import java.util.Map;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

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
    public Map<String,List<Producto>>getAllProducts(){
        long executionStart = System.currentTimeMillis();
        Map<String,List<Producto>> allProductos = this.productoUseCase.getAllProductos();
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return allProductos;
    }
    
    @POST
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductoRespuesta agregarProducto(
            @Context SecurityContext sec,
            ProductoRequest request){
        long executionStart = System.currentTimeMillis();
        
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        
        System.out.println(sec.getUserPrincipal());

        return new ProductoRespuesta();
    }
}
