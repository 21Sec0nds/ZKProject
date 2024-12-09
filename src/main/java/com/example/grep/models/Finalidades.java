package com.example.grep.models;

import jakarta.persistence.*;

@Entity
@Table(name = "FINALIDADES")
public class Finalidades {
    @Id
    @Column(name = "ID_FINALIDAD", nullable = false)
    private String id_finalidad;

    @Column(name = "NOMBRE_FINALIDAD", nullable = false)
    private String nombre_finalidad;

    public Finalidades() {}
    public String getIdFinalidad() { return id_finalidad; }
    public void setIdFinalidad(String id_finalidad) { this.id_finalidad = id_finalidad; }

    public String getNombreFinalidad() { return nombre_finalidad; }
    public void setNombreFinalidad(String nombre_finalidad) { this.nombre_finalidad = nombre_finalidad; }

}