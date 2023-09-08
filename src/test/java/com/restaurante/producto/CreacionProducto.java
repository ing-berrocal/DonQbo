/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Product;
import com.restaurante.servicio.categoria.Categoria;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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
    void obtenerTodosProductos() {

        ProductoRepositorio repositorio = Mockito.mock(ProductoRepositorio.class);

        Mockito.when(repositorio.getAllProducts()).thenReturn(getProducts());

        ProductoUseCase productoUseCase = new ProductoUseCase(repositorio);

        Map<String, List<Product>> allProductos = productoUseCase.getAllProductos();

        assertThat("Collecion de productos", allProductos, Matchers.aMapWithSize(3));
    }

    @ParameterizedTest
    @ValueSource(longs = { 1L, 2L })
    public void agregarProducto(final Long productId) {

        var newProducto = new Product(productId, "", "", "", "", "", BigDecimal.ZERO, Collections.emptyList(),
                Boolean.TRUE);

        ProductoRepositorio repositorio = Mockito.mock(ProductoRepositorio.class);

        Mockito.doAnswer(i -> {
            return new Product(productId, "", "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE);
        }).when(repositorio).agregarProducto(any(Product.class));

        ProductoUseCase productoUseCase = new ProductoUseCase(repositorio);

        productoUseCase.agregarProducto(newProducto);

        assertThat("Producto Id", newProducto.getId(), equalTo(productId));
    }

    List<Product> getProducts() {
        final String[] categorias = { "prom", "prod", "beb" };
        return Arrays.asList(
                new Product(1L, categorias[0], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(2L, categorias[0], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(3L, categorias[0], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(4L, categorias[1], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(5L, categorias[1], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(6L, categorias[1], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(7L, categorias[2], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(81L, categorias[2], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(9L, categorias[2], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(), Boolean.TRUE),
                new Product(10L, categorias[2], "", "", "", "", BigDecimal.ZERO, Collections.emptyList(),
                        Boolean.TRUE));
    }

}
