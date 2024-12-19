package com.example.grep.models;

import com.example.grep.services.DepartamentosService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "PRESUPUESTOS")
public class Presupuestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRESUPUESTO", nullable = false)
    private Integer id_presupuesto;

    @Column(name = "ANIO", nullable = false)
    private Integer anio;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO", nullable = false)
    private Departamentos id_departamento;

    @ManyToOne
    @JoinColumn(name = "ID_FINALIDAD", nullable = false)
    private Finalidades id_finalidad;

    @Column(name = "PRESUPUESTO", nullable = false)
    private Double presupuesto;





    public Presupuestos() {}


    public Integer getIdPresupuesto() { return id_presupuesto; }
    public void setIdPresupuesto(Integer id_presupuesto) { this.id_presupuesto = id_presupuesto; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public Departamentos getIdDepartamento() { return id_departamento; }
    public void setIdDepartamento(Departamentos id_departamento) { this.id_departamento = id_departamento; }



    public Finalidades getIdFinalidad() { return id_finalidad; }
    public void setIdFinalidad(Finalidades id_finalidad) { this.id_finalidad = id_finalidad; }

    public Double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(Double presupuesto) { this.presupuesto = presupuesto; }


}
