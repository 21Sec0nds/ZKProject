package com.example.grep.dto;

public class DetalleGastoDTO {

    private int idGasto;
    private String departamentoId;
    private String finalidad;
    private String mes;
    private int anio;
    private double importe;
    private String descripcion;
    private int idPresupuesto;
    private int anioPresupuesto;

    // Constructor
    public DetalleGastoDTO(int idGasto, String departamentoId, String finalidad,
                           String mes, int anio, double importe, String descripcion) {
        this.idGasto = idGasto;
        this.departamentoId = departamentoId;
        this.finalidad = finalidad;
        this.mes = mes;
        this.anio = anio;
        this.importe = importe;
        this.descripcion = descripcion;
    }

    // Getters and Setters
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(String finalidad) {
        this.finalidad = finalidad;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdPresupuesto() {  // Add getter
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {  // Add setter
        this.idPresupuesto = idPresupuesto;
    }

    public Integer getAnioPresupuesto() {
        return anioPresupuesto;
    }

    public void setAnioPresupuesto(Integer anioPresupuesto) {
        this.anioPresupuesto = anioPresupuesto;
    }
}
