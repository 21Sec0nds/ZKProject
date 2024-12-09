package com.example.grep.models;

import jakarta.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "TIPO_ESTADO_LIQUI")
public class TipoEstadoLiqui {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO", nullable = false)
    private Integer id_estado;

    @Column(name = "NOMBRE_ESTADO", nullable = false)
    private String nombre_estado;

    public TipoEstadoLiqui() {}
    public Integer getIdEstado() { return id_estado; }
    public void setIdEstado(Integer id_estado) { this.id_estado = id_estado; }

    public String getNombreEstado() { return nombre_estado; }
    public void setNombreEstado(String nombre_estado) { this.nombre_estado = nombre_estado; }

}