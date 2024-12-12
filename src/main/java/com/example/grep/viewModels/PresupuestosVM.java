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
import java.util.stream.Collectors;

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
        detalleDepartamentos = new ArrayList<>();
        detalleFinalidades = new ArrayList<>();
        if (listaPresupuestos.isEmpty()) {
            Executions.sendRedirect("/noPresupuestosPage.zul");
        }
    }

    @Command
    public void showDetails(@BindingParam("presupuestoId") int presupuestoId) {
        Presupuestos selectedPresupuesto = listaPresupuestos.stream()
                .filter(p -> p.getIdPresupuesto() == presupuestoId)
                .findFirst()
                .orElse(null);

        detalleDepartamentos = new ArrayList<>();
        detalleFinalidades = new ArrayList<>();

        if(selectedPresupuesto != null){
            if(selectedPresupuesto.getIdDepartamento() != null){
                detalleDepartamentos.add(selectedPresupuesto.getIdDepartamento());
            }
        }

        if (selectedPresupuesto.getIdFinalidad() != null) {
            detalleFinalidades.add(selectedPresupuesto.getIdFinalidad());
        }

        if( selectedPresupuesto.getIdDepartamento() != null){
            List<Departamentos> departamentosRealcionados = listaPresupuestos.stream()
                    .map(Presupuestos::getIdDepartamento)
                    .filter(d -> d != null && d.getNombreDepartamento().equalsIgnoreCase(selectedPresupuesto.getIdDepartamento().getNombreDepartamento()))
                    .distinct()
                    .collect(Collectors.toList());

            detalleDepartamentos.addAll(departamentosRealcionados);
        }

        if(selectedPresupuesto.getIdFinalidad() != null){
            List<Finalidades> finalidadesRelacionadas = listaPresupuestos.stream()
                    .map(Presupuestos::getIdFinalidad)
                    .filter(f -> f != null && f.getNombreFinalidad().equalsIgnoreCase(selectedPresupuesto.getIdFinalidad().getNombreFinalidad()))
                    .distinct()
                    .collect(Collectors.toList());

            detalleFinalidades.addAll(finalidadesRelacionadas);
        }

        HashMap<String, Object> params = new HashMap<>();
        params.put("presupuestoId", presupuestoId);
        params.put("presupuesto", selectedPresupuesto);
        params.put("detalleDepartamentos", detalleDepartamentos);
        params.put("detalleFinalidades", detalleFinalidades);

        Executions.sendRedirect("/presupuestos/details?presupuestoId=" + presupuestoId);
    }



    public Presupuestos getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Presupuestos selectedItem) {
        this.selectedItem = selectedItem;
    }
}
