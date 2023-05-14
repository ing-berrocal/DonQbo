/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.usuarios;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.PasswordProvider;
import io.quarkus.security.jpa.PasswordType;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author DELL
 */
@Table(schema = "donqbo",name = "tbl_usuario")
@Entity
@UserDefinition 
public class UsuarioEntity implements Serializable{
    public static final String FINDALL = "ProductoEntity_findAll";
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Username
    @Column(name = "user_username")
    private String username;
    @Column(name = "user_password")
    @Password(value = PasswordType.CLEAR/*, provider = CustomPasswordProvider.class*/)
    private String password;
    @Roles
    @Column(name = "user_role")
    private String role;
    @Transient
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /*class CustomPasswordProvider implements PasswordProvider {
        @Override
        public Password getPassword(String pass) {
            byte[] digest = DatatypeConverter.parseHexBinary(pass);
            return SimpleDigestPassword.createRaw(SimpleDigestPassword.ALGORITHM_SIMPLE_DIGEST_SHA_256, digest);
        }
    }*/

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}