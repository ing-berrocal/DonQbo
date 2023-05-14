/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author DELL
 */
public record Producto(
        Long id,
        String categoria,
        String codigo,
        String nombre,
        String descripcion,
        String urlImagen,
        BigDecimal valor,
        List<PromocionProducto> items) {
    
    public Producto(String categoria,String codigo,
        String nombre,
        String descripcion,
        String urlImagen,
        BigDecimal valor){
        this(null, categoria,codigo, nombre, descripcion, urlImagen, valor, Collections.EMPTY_LIST);
    }
    
    public static Producto newInstance(Long id,String categoria,String codigo,
        String nombre,
        String descripcion,
        String urlImagen,
        BigDecimal valor){
        return new Producto(id, categoria,codigo, nombre, descripcion, urlImagen, valor, null);
    }
}
