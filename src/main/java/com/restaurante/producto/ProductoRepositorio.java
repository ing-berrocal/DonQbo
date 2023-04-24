/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.model.Producto;
import java.util.List;

/**
 *
 * @author DELL
 */
interface ProductoRepositorio {

    public void agregarProducto(Producto any);

    public List<Producto> getAllProducts();
    
}
