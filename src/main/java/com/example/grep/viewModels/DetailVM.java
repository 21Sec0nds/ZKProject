package com.example.grep.viewModels;

import com.example.grep.models.Presupuestos;
import com.example.grep.services.PresupuestosService;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class DetailVM {

    @WireVariable
    private PresupuestosService presupuestosService;


    private Presupuestos presupuesto;

    @Init
    public void init(@ExecutionParam("presupuestoId") int presupuestoId) {

        presupuesto = presupuestosService.getPresupuestoById(presupuestoId);
    }

    public Presupuestos getPresupuesto() {
        return presupuesto;
    }

}
