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
    public void init(@ExecutionArgParam("presupuestoId") int presupuestoId) {
        this.presupuestoId = presupuestoId;
        presupuesto = presupuestosService.getPresupuestoById(presupuestoId);
    }

    public Presupuestos getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuestos presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getPresupuestoId() {
        return presupuestoId;
    }

    public void setPresupuestoId(int presupuestoId) {
        this.presupuestoId = presupuestoId;
    }
}
