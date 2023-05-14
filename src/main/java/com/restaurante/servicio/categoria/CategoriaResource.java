/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.servicio.categoria;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author DELL
 */
@Path("/categoria")
public class CategoriaResource {
    
    @Inject
    CategoriaUseCase categoriaUseCase;
    
    @GET
    public List<Categoria> getAllCategorias(){
        return categoriaUseCase.getAllCategorias();
    }
}
