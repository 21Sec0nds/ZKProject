package com.example.grep.models;


import jakarta.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "LIQUIDACIONES")
public class Liquidaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIQUIDACION", nullable = false)
    private Integer id_liquidacion;

    @Column(name = "AÑO", nullable = false)
    private Integer año;

    @Column(name = "MES", nullable = false)
    private Integer mes;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO", nullable = false)
    private Departamentos id_departamento;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private TipoEstadoLiqui id_estado;

    public Liquidaciones() {}

    public Integer getIdLiquidacion() { return id_liquidacion; }
    public void setIdLiquidacion(Integer id_liquidacion) { this.id_liquidacion = id_liquidacion; }

    public Integer getAño() { return año; }
    public void setAño(Integer año) { this.año = año; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Departamentos getIdDepartamento() { return id_departamento; }
    public void setIdDepartamento(Departamentos id_departamento) { this.id_departamento = id_departamento; }

    public TipoEstadoLiqui getIdEstado() { return id_estado; }
    public void setIdEstado(TipoEstadoLiqui id_estado) { this.id_estado = id_estado; }
}