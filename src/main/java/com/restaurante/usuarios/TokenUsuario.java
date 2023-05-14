/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.usuarios;

/**
 *
 * @author DELL
 */
public class TokenUsuario {
    private final UsuarioEntity usuario;
    private final String token;

    public TokenUsuario(UsuarioEntity usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }
    
    
}
