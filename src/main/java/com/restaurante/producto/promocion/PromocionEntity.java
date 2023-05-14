/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto.promocion;

import com.restaurante.producto.ProductoEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Table(schema = "donqbo",name = "tbl_promocion")
@Entity
@NamedQueries({
    @NamedQuery(name = PromocionEntity.FINDALL, query = "SELECT p FROM ProductoEntity p ORDER BY p.codigo")
})
public class PromocionEntity implements Serializable {

    public static final String FINDALL = "PromocionEntity_findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductoEntity producto;
    @Column
    private String nombre;
    @Column
    private Integer min_items;
    @Column
    private Integer max_items;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "donqbo",
            name = "tbl_promocion_producto",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<ProductoEntity> productos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMinItems() {
        return min_items;
    }

    public void setMinItems(Integer min_items) {
        this.min_items = min_items;
    }

    public Integer getMaxItems() {
        return max_items;
    }

    public void setMaxItems(Integer max_items) {
        this.max_items = max_items;
    }

    public List<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoEntity> productos) {
        this.productos = productos;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public ProductoEntity getProducto() {
        return producto;
    }
}