/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.util;

/**
 *
 * @author DELL
 */
public class Respuesta<T> {

    public Respuesta(T data) {
        this.data = data;
    }
    private final T data;

    public T getData() {
        return data;
    }
    
    public static <T> Respuesta getInstance(T data){
        return new Respuesta<T>(data);
    }
    
}
