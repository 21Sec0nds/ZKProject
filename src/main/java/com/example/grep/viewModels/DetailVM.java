package com.example.grep.viewModels;

import com.example.grep.models.Gastos;
import com.example.grep.models.Presupuestos;
import com.example.grep.services.GastosService;
import com.example.grep.services.PresupuestosService;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.ArrayList;
import java.util.List;

public class DetailVM {

    @WireVariable
    private PresupuestosService presupuestosService;
    @WireVariable
    private GastosService gastosService;

    private Presupuestos presupuesto;

    public List<Gastos> getDetalleGastos() {
        return detalleGastos;
    }

    private List<Gastos> detalleGastos = new ArrayList<>();

    @Init
    public void init(@ExecutionParam("presupuestoId") int presupuestoId) {
        presupuesto = presupuestosService.getPresupuestoById(presupuestoId);

        if (presupuesto != null) {
            detalleGastos = gastosService.getGastosByFilters(
                    presupuesto.getIdDepartamento() != null ? presupuesto.getIdDepartamento().getIdDepartamento() : null,
                    presupuesto.getIdFinalidad() != null ? presupuesto.getIdFinalidad().getIdFinalidad() : null,
                    presupuesto.getAnio()
            );
        }
    }

    public Presupuestos getPresupuesto() {
        return presupuesto;
    }

}
