/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.usuarios;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class UsuarioPersistencia implements UsuarioRepositorio{
    
    @Inject
    private EntityManager entitiManager;
    
    @Transactional
    @Override
    public UsuarioEntity agregarUsuario() {
        UsuarioEntity ue = new UsuarioEntity();
        
        ue.setUsername("alice");
        ue.setPassword("alice");
        ue.setRole("admin");

        this.entitiManager.persist(ue);
        return ue;
    }
}
