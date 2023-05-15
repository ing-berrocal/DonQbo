/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import com.restaurante.model.ProductoRequest;
import com.restaurante.respuesta.ProductoRespuesta;
import com.restaurante.util.Respuesta;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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
    public Respuesta<List<Producto>> getProducts(){
        long executionStart = System.currentTimeMillis();
        List<Producto> allProductos = this.productoUseCase.getProductos();
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return Respuesta.getInstance(allProductos);
    }
    
    @GET
    @Path(value = "/by-id/{id}")
    public Respuesta<Producto> getProductById(@PathParam("id") Long id){
        long executionStart = System.currentTimeMillis();
        Optional<Producto> producto = this.productoUseCase.getProductoById(id);
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return producto.map(Respuesta::getInstance).get();
    }
    
    @POST    
    public Respuesta agregarProducto(
            @Context SecurityContext sec,
            ProductoRequest request){
        long executionStart = System.currentTimeMillis();
        Producto agregarProducto = productoUseCase.agregarProducto(
                Producto.newInstance(
                        0L,
                        request.getCodigoCategoria(),
                        "",
                        request.getNombre(),
                        request.getDescripcion(),
                        null, 
                        BigDecimal.valueOf(request.getValor()))
        );
        long executionEnd = System.currentTimeMillis();
        Long diff = executionEnd - executionStart;
        System.out.println(diff);
        return Respuesta.getInstance(agregarProducto);
    }
}
