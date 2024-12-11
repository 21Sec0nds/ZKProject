package com.example.grep.viewModels;

import com.example.grep.models.Presupuestos;
import com.example.grep.services.PresupuestosService;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class DetailVM {

    @WireVariable
    private PresupuestosService presupuestosService;

    private Presupuestos presupuesto;
    private int presupuestoId;


    @Init
    public void init(@ExecutionParam("presupuestoId") int presupuestoId) {
        this.presupuestoId = presupuestoId;
    }

    public Presupuestos getPresupuesto() {
        return presupuesto;
    }

    public int getPresupuestoId() {
        return presupuestoId;
    }
}