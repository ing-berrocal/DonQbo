/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.respuesta;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Promocion {
    
    private Long id;
    private String nombre;
    private Integer min_productos;
    private Integer max_productos;
    private List<ProductoRespuesta> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMin_productos() {
        return min_productos;
    }

    public void setMin_productos(Integer min_productos) {
        this.min_productos = min_productos;
    }

    public Integer getMax_productos() {
        return max_productos;
    }

    public void setMax_productos(Integer max_productos) {
        this.max_productos = max_productos;
    }

    public List<ProductoRespuesta> getItems() {
        return items;
    }

    public void setItems(List<ProductoRespuesta> items) {
        this.items = items;
    }
    
    
}
