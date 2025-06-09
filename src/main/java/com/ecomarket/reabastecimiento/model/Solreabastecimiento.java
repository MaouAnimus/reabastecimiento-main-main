package com.ecomarket.reabastecimiento.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitud_resupply")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Solreabastecimiento {
    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solicitud;

    @ManyToOne
    @JoinColumn(name = "id_prov", nullable = false)
    private Proveedor proveedor;
    
    @ManyToOne
    @JoinColumn(name = "id_encargado", nullable = false)
    private EncargadoTienda encargado;

    @ManyToOne
    @JoinColumn(name = "id_tienda", nullable = false)
    private Tienda tienda;

    @Column(nullable = false)
    private boolean estado_solicitud;
    
    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    
}
