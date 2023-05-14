/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.producto;

import com.restaurante.producto.promocion.PromocionEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Table(schema = "donqbo",name = "tbl_producto")
@Entity
@NamedQueries({
    @NamedQuery(name = ProductoEntity.FINDALL,query = "SELECT p FROM ProductoEntity p ORDER BY p.codigo")
})
public class ProductoEntity implements Serializable{
    public static final String FINDALL = "ProductoEntity_findAll";
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column
    private String categoria;
    @Column
    private String codigo;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column(name = "uuid_imagen")
    private String urlImagen;
    @Column(name = "valor_venta")
    private BigDecimal valor;
    @Column(name = "es_promocion")
    private Boolean esPromocion;
    @OneToMany(mappedBy = "producto",fetch = FetchType.EAGER)
    private List<PromocionEntity> items;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEsPromocion(Boolean esPromocion) {
        this.esPromocion = esPromocion;
    }

    public Boolean getEsPromocion() {
        return esPromocion;
    }

    public void setItems(List<PromocionEntity> items) {
        this.items = items;
    }

    public List<PromocionEntity> getItems() {
        return items;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
