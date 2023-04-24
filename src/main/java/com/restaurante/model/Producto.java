/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.model;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public record Producto(Long id,String codigo,
        String nombre,
        String descripcion,
        String urlImagen,
        BigDecimal valor) {    
    
    public static Producto newInstance(Long id,String codigo,
        String nombre,
        String descripcion,
        String urlImagen,
        BigDecimal valor){
        return new Producto(id, codigo, nombre, descripcion, urlImagen, valor);
    }
}
