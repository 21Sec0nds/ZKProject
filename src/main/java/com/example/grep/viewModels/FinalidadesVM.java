package com.example.grep.viewModels;

import com.example.grep.models.Finalidades;
import com.example.grep.models.Presupuestos;
import com.example.grep.services.FinalidadesService;
import com.example.grep.services.PresupuestosService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.util.ArrayList;
import java.util.List;

public class FinalidadesVM {

    @WireVariable
    private FinalidadesService finalidadesService;

    @WireVariable
    private PresupuestosService presupuestosService;

    private List<Finalidades> listaFinalidades;
    private String idFinalidad;
    private String nombreFinalidad;
    private List<Presupuestos> detallePresupuestos;
    private Finalidades selectedItem;

    public List<Finalidades> getListaFinalidades() {return listaFinalidades;}
    public void setListaFinalidades(List<Finalidades> listaFinalidades) {this.listaFinalidades = listaFinalidades;}

    public String getIdFinalidad() {return idFinalidad;}
    public void setIdFinalidad(String idFinalidad) {this.idFinalidad = idFinalidad;}

    public String getNombreFinalidad() {return nombreFinalidad;}
    public void setNombreFinalidad(String nombreFinalidad) {this.nombreFinalidad = nombreFinalidad;}

    public List<Presupuestos> getDetallePresupuestos() {return detallePresupuestos;}
    public void setDetallePresupuestos(List<Presupuestos> detallePresupuestos) {this.detallePresupuestos = detallePresupuestos;}

    public PresupuestosService getPresupuestosService() {return presupuestosService;}
    public void setPresupuestosService(PresupuestosService presupuestosService) {this.presupuestosService = presupuestosService;}

    public Finalidades getSelectedItem() {
        return selectedItem;
    }

    @NotifyChange({"detallePresupuestos"})
    public void setSelectedItem(Finalidades selectedItem){
        this.selectedItem =selectedItem;

        // Actualiza la lista
        if (selectedItem != null) {
            detallePresupuestos = presupuestosService.getPresupuestoByFinalidad(selectedItem.getIdFinalidad());
        } else {
            detallePresupuestos = new ArrayList<>();
        }
    }

    @Init
    public void init(){
        listaFinalidades = new ListModelList<>(finalidadesService.getAllFinalidades());
    }
}
