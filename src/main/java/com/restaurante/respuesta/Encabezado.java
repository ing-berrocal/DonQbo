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
public class Encabezado {
    
    private String codigo;
    private List<ProductoRespuesta> productos;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<ProductoRespuesta> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoRespuesta> productos) {
        this.productos = productos;
    }
    
    
}
