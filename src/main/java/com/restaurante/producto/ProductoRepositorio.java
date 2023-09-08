/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Product;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DELL
 */
interface ProductoRepositorio {

    public Product agregarProducto(Product any);

    public void editProduct(Product any);

    public List<Product> getAllProducts();

    public Optional<Product> getProductoById(long Id);

}
