package com.restaurante.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Product {

        private Long id;
        private final String categoria;
        private String codigo;
        private String nombre;
        private final String descripcion;
        private final String urlImagen;
        private final BigDecimal valor;
        private List<PromocionProducto> items;
        private Boolean estaActivo;

        private Product(String categoria, String codigo, String nombre, String descripcion, String urlImagen,
                        BigDecimal valor) {
                this.categoria = categoria;
                this.codigo = codigo;
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.urlImagen = urlImagen;
                this.valor = valor;
        }

        public static Product createInstanceProduct(
                        String category,
                        String code,
                        String name,
                        String description,
                        String urlImage,
                        BigDecimal value) {
                return new Product(category, code, name, description, urlImage, value);
        }

        public Product(Long id,
                        String categoria, String codigo, String nombre, String descripcion, String urlImagen,
                        BigDecimal valor, List<PromocionProducto> items, Boolean isActive) {
                this.id = id;
                this.categoria = categoria;
                this.codigo = codigo;
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.urlImagen = urlImagen;
                this.valor = valor;
                this.items = items;
                this.estaActivo = isActive;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCategoria() {
                return categoria;
        }

        public String getCodigo() {
                return codigo;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getNombre() {
                return nombre;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public String getUrlImagen() {
                return urlImagen;
        }

        public BigDecimal getValor() {
                return valor;
        }

        public List<PromocionProducto> getItems() {
                return items;
        }

        public void setItems(List<PromocionProducto> items) {
                this.items = items;
        }

        public Boolean getEstaActivo() {
                return estaActivo;
        }

        public void setEstaActivo(Boolean isActive) {
                this.estaActivo = isActive;
        }

        public void setCodigo(String codigo) {
                this.codigo = codigo;
        }

}
