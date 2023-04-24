/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.example.graphqle.model;

/**
 *
 * @author DELL
 */
public class Ally implements Character , SearchResult{
    public String name;
    public String surname;
    public Hero partner;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }        
}
