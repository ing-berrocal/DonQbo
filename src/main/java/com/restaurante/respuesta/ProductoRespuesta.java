/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.respuesta;

/**
 *
 * @author DELL
 */
public class ProductoRespuesta {
    
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Boolean esPromocion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getEsPromocion() {
        return esPromocion;
    }

    public void setEsPromocion(Boolean esPromocion) {
        this.esPromocion = esPromocion;
    }
    
    
}
