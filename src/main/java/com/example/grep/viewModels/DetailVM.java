package com.example.grep.viewModels;

import com.example.grep.interfaces.IDepartamentos;
import com.example.grep.interfaces.IFinalidades;
import com.example.grep.interfaces.IUsuarios;
import com.example.grep.models.*;
import com.example.grep.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

import java.util.ArrayList;
import java.util.List;

public class DetailVM {

    // Services and Repositories
    @WireVariable
    private PresupuestosService presupuestosService;

    @WireVariable
    private GastosService gastosService;

    @WireVariable
    private Usuarios usuarioService;

    @WireVariable
    private FinalidadesService finalidadesService;

    @WireVariable
    private DepartamentosService departamentoService;

    // Properties
    private int anio;
    private Presupuestos presupuesto;
    private Departamentos departamentos;
    private Finalidades finalidades;
    private double presupuestop;
    private Departamentos id_departamento;

    private String nombreFinalidad;
    private String nombreDepartamento;
    private String idFinalidad;
    private Finalidades id_finalidad;
    private List<Gastos> detalleGastos = new ArrayList<>();

    // Getters and Setters
    public String getNombreFinalidad() {
        return nombreFinalidad;
    }




    public int getAnio() {
        return anio;
    }

    public void setNombreFinalidad(String nombreFinalidad) {
        this.nombreFinalidad = nombreFinalidad;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setId_finalidad(Finalidades id_finalidad) {
        this.id_finalidad = id_finalidad;
    }

    public List<Gastos> getDetalleGastos() {
        return detalleGastos;
    }

    public String getIdFinalidad() {
        return idFinalidad;
    }

    public Presupuestos getPresupuesto() {
        return presupuesto;
    }

    // Save Methods
    public Finalidades saveFinalidades(Finalidades finalidades) {
        return this.finalidadesService.saveFinalidades(finalidades);
    }

    public Departamentos saveDepartamentos(Departamentos departamentos) {
        return departamentoService.saveDepartamentos(departamentos);
    }

    // Initialization
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

    // Command Methods
    @Command
    @NotifyChange({"nombreDepartamento", "anio", "nombreFinalidad", "presupuesto"})
    public void guardarUsuario() {

        if (presupuesto == null || presupuesto.getIdDepartamento() == null || presupuesto.getAnio() == 0) {
            Messagebox.show("Todos los campos son obligatorios.", "Error", Messagebox.OK, Messagebox.ERROR);
            return;
        }

        if (nombreFinalidad == null || nombreFinalidad.trim().isEmpty()) {
            Messagebox.show("El campo 'Nombre Finalidad' es obligatorio.", "Error", Messagebox.OK, Messagebox.ERROR);
            return;
        }

        if (nombreDepartamento == null || nombreDepartamento.trim().isEmpty()) {
            Messagebox.show("El campo 'Nombre Departamento' es obligatorio.", "Error", Messagebox.OK, Messagebox.ERROR);
            return;
        }


        if (finalidades == null) {
            finalidades = new Finalidades();
        }
        finalidades.setNombreFinalidad(nombreFinalidad);


        if (departamentos == null) {
            departamentos = new Departamentos();
        }
        departamentos.setNombreDepartamento(nombreDepartamento);


        presupuesto.setAnio(anio);

        presupuesto.getIdFinalidad().setNombreFinalidad(nombreFinalidad);
        presupuesto.getIdDepartamento().setNombreDepartamento(nombreDepartamento);
//        presupuesto.getAnio().
//
//
//        presupuestosService.savePresupuesto(presupuesto);
//        departamentoService.getDepartamentos().sa
//        departamentoService.saveDepartamentos(getNombreDepartamento());

    }

}
