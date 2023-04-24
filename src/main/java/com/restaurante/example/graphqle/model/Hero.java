/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.example.graphqle.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Hero implements Character , SearchResult{
    public String name;
    public String surname;
    public Double height;
    public Integer mass;
    public Boolean darkSide;
    public LightSaber lightSaber;
    public List<Integer> episodeIds = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }
    

    @Override
    public String getSurname() {
        return surname;
    }
}
