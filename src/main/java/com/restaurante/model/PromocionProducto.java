/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.model;

import java.util.List;

/**
 *
 * @author DELL
 */
public record PromocionProducto(
        Long id,
        String nombre,
        Integer minItems,
        Integer maxItems,
        List<Producto> productos) {
}
