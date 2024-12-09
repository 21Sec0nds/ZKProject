package com.example.grep.models;

import jakarta.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "GASTOS")
public class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GASTO", nullable = false)
    private Integer idGasto;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO", nullable = false)
    private Departamentos departamento;

    @OneToOne
    @JoinColumn(name = "ID_FINALIDAD", nullable = false)
    private Finalidades finalidad;

    @Column(name = "MES", nullable = false)
    private Integer mes;

    @Column(name = "AÑO", nullable = false)
    private Integer anio;

    @Column(name = "IMPORTE", nullable = false)
    private Double importe;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "JUSTIFICANTE")
    private byte[] justificante;

    // Constructor por defecto
    public Gastos() {}

    // Getters y Setters
    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public Departamentos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
    }

    public Finalidades getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(Finalidades finalidad) {
        this.finalidad = finalidad;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getJustificante() {
        return justificante;
    }

    public void setJustificante(byte[] justificante) {
        this.justificante = justificante;
    }
}
