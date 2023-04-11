/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;

/**
 *
 * @author DELL
 */
public class CreacionProducto {
    
    public CreacionProducto() {
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
    @ParameterizedTest
    @ValueSource(longs={1L,2L})
    public void agregarProducto(long productoId) {
        
        var producto = new Producto();
        
        ProductoRepositorio repositorio = Mockito.mock(ProductoRepositorio.class);
        
        Mockito.doAnswer(i->{
            var p = i.getArgument(0,Producto.class);
            p.setId(productoId);
            return p;
        }).when(repositorio).agregarProducto(any(Producto.class));
        
        ProductoUseCase productoUseCase = new ProductoUseCase(repositorio);
        
        productoUseCase.agregarProducto(producto);
        
        assertThat("Producto Id",producto.getId(),equalTo(productoId));
    }
}
