package com.example.grep.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "FINALIDADES")
public class Finalidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FINALIDAD", nullable = false)
    private String id_finalidad;

    @Column(name = "NOMBRE_FINALIDAD", nullable = false)
    private String nombreFinalidad;

    public Finalidades() {}
    public String getIdFinalidad() { return id_finalidad; }
    public void setIdFinalidad(String id_finalidad) { this.id_finalidad = id_finalidad; }


    public String getNombreFinalidad() {
        return nombreFinalidad;
    }

    public void setNombreFinalidad(String nombreFinalidad) {
        this.nombreFinalidad = nombreFinalidad;
    }


}
