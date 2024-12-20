package com.example.grep.dto;

public class PresupuestosDTO {

    private Integer idPresupuesto;
    private Integer anio;
    private Integer idDepartamento;
    private String idFinalidad;
    private Double presupuesto;

    // Constructor
    public PresupuestosDTO(Integer idPresupuesto, Integer anio, Integer idDepartamento, String idFinalidad, Double presupuesto) {
        this.idPresupuesto = idPresupuesto;
        this.anio = anio;
        this.idDepartamento = idDepartamento;
        this.idFinalidad = idFinalidad;
        this.presupuesto = presupuesto;
    }

    // Getters and Setters
    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdFinalidad() {
        return idFinalidad;
    }

    public void setIdFinalidad(String idFinalidad) {
        this.idFinalidad = idFinalidad;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
