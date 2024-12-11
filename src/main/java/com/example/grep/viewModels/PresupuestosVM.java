package com.example.grep.viewModels;

import com.example.grep.models.Departamentos;
import com.example.grep.models.Finalidades;
import com.example.grep.models.Presupuestos;
import com.example.grep.services.PresupuestosService;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PresupuestosVM {

    @WireVariable
    private PresupuestosService presupuestosService;
    private List<Presupuestos> listaPresupuestos;
    private Presupuestos selectedItem;
    private List<Departamentos> detalleDepartamentos;
    private List<Finalidades> detalleFinalidades;

    private int id_presupuesto;
    private int anio;
    private Departamentos id_departamento;
    private Finalidades id_finalidad;
    private double presupuesto;

    public List<Presupuestos> getListaPresupuestos() {
        return listaPresupuestos;
    }

    public int getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(int id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Departamentos getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Departamentos id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Finalidades getId_finalidad() {
        return id_finalidad;
    }

    public void setId_finalidad(Finalidades id_finalidad) {
        this.id_finalidad = id_finalidad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Departamentos> getDetalleDepartamentos() {
        return detalleDepartamentos;
    }

    public List<Finalidades> getDetalleFinalidades() {
        return detalleFinalidades;
    }

    @Init
    public void init() {
        listaPresupuestos = new ListModelList<>(presupuestosService.getAllPresupuestos());

        // Log the loaded presupuestos
        System.out.println("Loaded presupuestos: " + listaPresupuestos);

        if (listaPresupuestos.isEmpty()) {
            System.out.println("No presupuestos found. Redirecting to noPresupuestosPage.zul");
            Executions.sendRedirect("/noPresupuestosPage.zul");
        }
    }

    @NotifyChange({"detalleDepartamentos", "detalleFinalidades"})
    public void setSelectedItem(Presupuestos selectedItem) {
        this.selectedItem = selectedItem;

        if (selectedItem != null) {
            detalleDepartamentos = List.of(selectedItem.getIdDepartamento());
            detalleFinalidades = List.of(selectedItem.getIdFinalidad());

            HashMap<String, Object> params = new HashMap<>();
            params.put("presupuestoId", selectedItem.getIdPresupuesto()); // Pass presupuestoId
            Executions.createComponents("/presupuestos/details.zul", null, params); // Dynamically load details.zul
        } else {
            detalleDepartamentos = new ArrayList<>();
            detalleFinalidades = new ArrayList<>();
        }
    }



    public Presupuestos getSelectedItem() {
        return selectedItem;
    }
}
