package com.ecomarket.reabastecimiento.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "producto")
public class Producto {
    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id_producto;

    @Column(length = 15, nullable = false, unique = true)
    private String codigo_producto;

    @Column(length = 50, nullable = false)
    private String nombre_producto;

    @Column(nullable = false)
    private int cantidad_producto;
    
}
