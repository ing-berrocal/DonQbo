/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    @Test
    void obtenerTodosProductos(){
                
        ProductoRepositorio repositorio = Mockito.mock(ProductoRepositorio.class);
        
        Mockito.when(repositorio.getAllProducts()).thenReturn(getProductos());
        
        ProductoUseCase productoUseCase = new ProductoUseCase(repositorio);
        
        Map<String,List<Producto>> allProductos = productoUseCase.getAllProductos();
        
        assertThat("Collecion de productos",allProductos,Matchers.aMapWithSize(10));
    }
    
    @ParameterizedTest
    @ValueSource(longs={1L,2L})
    public void agregarProducto(long productoId) {
        
        var newProducto = new Producto("","","","", "",BigDecimal.ZERO);
        
        ProductoRepositorio repositorio = Mockito.mock(ProductoRepositorio.class);
        
        Mockito.doAnswer(i->{
            return new Producto("","","","","",BigDecimal.ZERO);
        }).when(repositorio).agregarProducto(any(Producto.class));
        
        ProductoUseCase productoUseCase = new ProductoUseCase(repositorio);
        
        var productoRegistred = productoUseCase.agregarProducto(newProducto);
        
        assertThat("Producto Id",productoRegistred.id(),equalTo(productoId));
    }
    
    List<Producto> getProductos(){
        return Arrays.asList(
                new Producto(1L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(2L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(3L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(4L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(5L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(6L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(7L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(8L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(9L,"","","","","",BigDecimal.ZERO,Collections.emptyList()),
                new Producto(10L,"","","","","",BigDecimal.ZERO,Collections.emptyList())
        );
    }
}
