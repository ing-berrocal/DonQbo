/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.restaurante.producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class ActualizarProducto {
    
    public ActualizarProducto() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        
        minimalOperations(Arrays.asList("ad","abb"));
    
    }
    
    public static List<Integer> minimalOperations(List<String> words) {
        
        List <Integer> resultados = new ArrayList<>();
        
        for(String word : words){
            
            System.out.println(word);
            
            String[] w = word.split("");    
            
            /*if(w.length < 2){
                resultados.add(0);
                continue;
            }*/
            
            Integer resultado = 0;
            for(int i=1;i<w.length;i++){
                
                int j=i-1;
                int k=i;
                System.out.println(w[j]+" "+w[i]);
                if(w[j].equals(w[i])){
                    resultado++;
                }
                
            }
            resultados.add(resultado);
        }
        
        return resultados;
    }
}
