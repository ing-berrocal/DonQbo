/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.servicio.categoria;

import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class CategoriaUseCase {
    
    private static Map<String,Categoria> categorias;
    
    {
        categorias = Map.of("proms", 
                new Categoria("proms", "Promociones"), 
                "cbn", new Categoria("cbn", "Cubanos"), 
                "bbd", new Categoria("bbd", "Bebidas"));
    }
    
    List<Categoria> getAllCategorias(){
        return List.copyOf(this.categorias.values());
    }
    
    Categoria getCategoriaPorCodigo(String codigoCategora) {
        return categorias.get(codigoCategora);
    }
    
}
