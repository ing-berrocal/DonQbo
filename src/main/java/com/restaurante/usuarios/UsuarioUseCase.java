/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.usuarios;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class UsuarioUseCase {

    private final UsuarioRepositorio repositorio;
    
    public UsuarioUseCase(UsuarioRepositorio productoRepositorio) {
        this.repositorio = productoRepositorio;
    }
    
    UsuarioEntity usuario() {
        return this.repositorio.agregarUsuario();
    }
    
}
