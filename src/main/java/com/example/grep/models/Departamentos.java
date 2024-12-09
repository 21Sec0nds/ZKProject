package com.example.grep.models;


import jakarta.persistence.*;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    private Integer id_departamento;

    @Column(name = "NOMBRE_DEPARTAMENTO", nullable = false)
    private String nombre_departamento;

    public Departamentos() {}
    public Integer getIdDepartamento() { return id_departamento; }
    public void setIdDepartamento(Integer id_departamento) { this.id_departamento = id_departamento; }

    public String getNombreDepartamento() { return nombre_departamento; }
    public void setNombreDepartamento(String nombre_departamento) { this.nombre_departamento = nombre_departamento; }

}
