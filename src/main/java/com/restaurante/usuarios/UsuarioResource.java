/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.usuarios;

import com.restaurante.util.Respuesta;
import io.smallrye.jwt.build.Jwt;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.eclipse.microprofile.jwt.Claims;

/**
 *
 * @author DELL
 */
@Path("/public/login")
public class UsuarioResource {
    
    @Inject
    UsuarioUseCase productoUseCase;
    
    @POST
    @PermitAll
    public Respuesta generate(){    
        
        UsuarioEntity ue = new UsuarioEntity();
        
        ue.setUsername("alice");
        ue.setPassword("alice");
        ue.setRole("admin");
        ue.setEmail("email@email.com");
        
        return new Respuesta<TokenUsuario>(
                new TokenUsuario(ue, Jwt.issuer("https://example.com/issuer")
                .upn("jhondoe@quarkus.com")
                .groups(new HashSet<>(Arrays.asList("admin","user")))
                .claim(Claims.full_name, "Daniel Antonio Berrocal")
                .claim(Claims.birthdate, "2001-07-13")
                        .expiresIn(Duration.ofDays(4L))
                .sign())
                
                
        );
        
    }
    
    @GET
    @PermitAll
    public UsuarioEntity get(){
        
        return this.productoUseCase.usuario();
    }
    
}
