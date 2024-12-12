package com.example.grep.viewModels;

import com.example.grep.models.Gastos;
import com.example.grep.models.Presupuestos;
import com.example.grep.services.PresupuestosService;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.ArrayList;
import java.util.List;

public class DetailVM {

    @WireVariable
    private PresupuestosService presupuestosService;


    private Presupuestos presupuesto;

    public List<Gastos> getDetalleGastos() {
        return detalleGastos;
    }

    private List<Gastos> detalleGastos = new ArrayList<>();

    @Init
    public void init(@ExecutionParam("presupuestoId") int presupuestoId) {
        presupuesto = presupuestosService.getPresupuestoById(presupuestoId);
        Gastos gastos = new Gastos();
        gastos.setAnio(2004);
        detalleGastos.add(gastos);
    }

    public Presupuestos getPresupuesto() {
        return presupuesto;
    }

}
