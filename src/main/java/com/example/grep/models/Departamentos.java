package com.example.grep.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    private Integer idDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO", nullable = false)
    private String nombreDepartamento;

    public Departamentos() {}

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
