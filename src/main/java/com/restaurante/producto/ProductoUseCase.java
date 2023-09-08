/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.google.protobuf.Option;
import com.restaurante.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author DELL
 */
@ApplicationScoped
class ProductoUseCase {

    ProductoUseCase(com.restaurante.producto.ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    private final ProductoRepositorio productoRepositorio;
    private Optional<Optional<Product>> ofNullable;

    public Map<String, List<Product>> getAllProductos() {
        return this.productoRepositorio.getAllProducts()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategoria));
    }

    public List<Product> getProductos() {
        return this.productoRepositorio.getAllProducts();
    }

    public Optional<Product> getProductoById(long Id) {
        return this.productoRepositorio.getProductoById(Id);
    }

    Product agregarProducto(Product producto) {
        return this.productoRepositorio.agregarProducto(producto);
    }

    Product editarProducto(Product producto) {

        final String nombre = producto.getNombre();
        final String description = producto.getDescripcion();
        final String url = producto.getUrlImagen();
        final BigDecimal value = producto.getValor();
        final Boolean isActive = producto.getEstaActivo();

        Product p = productoRepositorio.getProductoById(producto.getId())
                .map(arg0 -> new Product(
                        arg0.getId(),
                        arg0.getCategoria(),
                        arg0.getCodigo(),
                        nombre,
                        description,
                        url,
                        value,
                        arg0.getItems(),
                        isActive))
                .orElseThrow();

        productoRepositorio.editProduct(p);

        return p;
    }

}
