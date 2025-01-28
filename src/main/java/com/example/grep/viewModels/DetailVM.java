package com.example.grep.viewModels;

import com.example.grep.models.*;
import com.example.grep.services.*;
import org.hibernate.tool.schema.spi.Exporter;
import org.zkoss.bind.annotation.*;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Messagebox;

import java.awt.print.Book;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetailVM {

    // This method runs once after page load
    @AfterCompose
    public void init1() {
        // If the user is already logged in, redirect them to the main page
        if (isUserLoggedIn()) {
            // Do nothing if user is logged in
        } else{
            Executions.sendRedirect("/presupuestos/login");
        }
    }

    // Helper method to check if the user is logged in
    private boolean isUserLoggedIn() {
        Session session = Executions.getCurrent().getSession();
        return session.getAttribute("LoggedInUser") != null;
    }
    //------------------------------------------------- Services and Repositories ---------------------------------------
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
    //------------------------------------------------- Properties ---------------------------------------
    private int mes;
    private String description;
    private int idGasto;
    private double importe;

    private int anio;
    private Presupuestos presupuesto;
    private Departamentos departamentos;
    private Finalidades finalidades;
    private double presupuestop;
    private Departamentos id_departamento;
    private String departamento;

    private String nombreFinalidad;
    private String nombreFinalidad2;
    private String nombreDepartamento;
    private String nombreDepartamento2;
    private String idFinalidad;
    private Finalidades id_finalidad;
    private List<Gastos> detalleGastos = new ArrayList<>();
    private List<Gastos> newlist = new ArrayList<>();

    //------------------------------------------------- Getters and Setters ---------------------------------------
    public String getNombreFinalidad() { return nombreFinalidad; }
    public void setNombreFinalidad(String nombreFinalidad) { this.nombreFinalidad = nombreFinalidad; }

    public String getNombreFinalidad2() { return nombreFinalidad2; }
    public void setNombreFinalidad2(String nombreFinalidad2) { this.nombreFinalidad2 = nombreFinalidad2; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getNombreDepartamento() { return nombreDepartamento; }
    public void setNombreDepartamento(String nombreDepartamento) { this.nombreDepartamento = nombreDepartamento; }

    public String getNombreDepartamento2() { return nombreDepartamento2; }
    public void setNombreDepartamento2(String nombreDepartamento2) { this.nombreDepartamento2 = nombreDepartamento2; }

    public List<Gastos> getDetalleGastos() { return detalleGastos; }

    public List<Gastos> getNewlist(){return newlist;}

    public String getIdFinalidad() { return idFinalidad; }

    public void setIdGasto(int idGasto) {this.idGasto = idGasto;}

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public Presupuestos getPresupuesto() { return presupuesto; }

    public double getImporte() { return importe; }
    public void setImporte(double importe) { this.importe = importe; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public void setId_finalidad(Finalidades id_finalidad) { this.id_finalidad = id_finalidad; }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    //------------------------------------------------- Save Methods ---------------------------------------
    private Finalidades saveFinalidades(Finalidades finalidades) {
        return this.finalidadesService.saveFinalidades(finalidades);
    }

    private Departamentos saveDepartamentos(Departamentos departamentos) {
        return this.departamentoService.saveDepartamentos(departamentos);
    }

    private Presupuestos saveAnio(Presupuestos anio) {
        return this.presupuestosService.saveAnio(anio);
    }

    private Gastos saveGasto(Gastos gasto){
        return  this.gastosService.saveGastos(gasto);
    }

    // --------------------------------------- Initialization ---------------------------------------
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
        if (detalleGastos == null || detalleGastos.isEmpty()) {
            detalleGastos.add(new Gastos());
        }
    }
    //--------------------------------------- Command Methods---------------------------------------
    @Command
    @NotifyChange({"nombreDepartamento", "anio", "nombreFinalidad", "presupuesto"})
    public void guardarUsuario() {



        if (presupuesto.getIdFinalidad() == null) {
            presupuesto.setIdFinalidad(new Finalidades());
        }
        if (presupuesto.getIdDepartamento() == null) {
            presupuesto.setIdDepartamento(new Departamentos());
        }

        Finalidades finalidadToUpdate = finalidadesService.getFinalidadByNombre(nombreFinalidad);

        if (finalidadToUpdate == null) {
            finalidadToUpdate = new Finalidades();
            finalidadToUpdate.setNombreFinalidad(nombreFinalidad);
            saveFinalidades(finalidadToUpdate);
        }

        presupuesto.setIdFinalidad(finalidadToUpdate);

        Departamentos departamentoToUpdate = departamentoService.getDepartamentoByNombre(nombreDepartamento);

        if (departamentoToUpdate == null) {
            departamentoToUpdate = new Departamentos();
            departamentoToUpdate.setNombreDepartamento(nombreDepartamento);
            saveDepartamentos(departamentoToUpdate);
        }

        presupuesto.setIdDepartamento(departamentoToUpdate);

        presupuesto.setAnio(getAnio());
        presupuestosService.saveAnio(presupuesto);
    }
    @Command
    @NotifyChange({"mes", "importe", "description", "detalleGastos"})
    public void addGasto() {
        if (mes <= 0 || importe <= 0 || description == null || description.trim().isEmpty()) {
            Messagebox.show("Por favor, complete todos los campos del gasto.", "Error", Messagebox.OK, Messagebox.ERROR);
            return;
        }

        Departamentos departamento = departamentoService.getDepartamentos(presupuesto.getIdDepartamento().getIdDepartamento());

        Finalidades finalidades2 = finalidadesService.getFinalidades(presupuesto.getIdFinalidad().getIdFinalidad());

        Gastos gasto = new Gastos();
        gasto.setMes(mes);
        gasto.setAnio(presupuesto.getAnio());
        gasto.setImporte(importe);
        gasto.setDescripcion(description);
        gasto.setDepartamento(departamento);
        gasto.setFinalidad(finalidades2);

        saveGasto(gasto);
        detalleGastos.add(gasto);

        resetGastoFields();
    }

    private void resetGastoFields() {
        setMes(0);
        setImporte(0);
        setDescription("");
        setNombreDepartamento2("");
        setNombreFinalidad2(null);
        setAnio(0);
    }
    @Command
    @NotifyChange({"Id"})
    public void FindById() {
        Executions.sendRedirect("/api/pdf/generate?Presupuesto=" + presupuesto.getIdPresupuesto());
    }


    //Security
    @Command
    public void checkLogin() {
        Session session = Executions.getCurrent().getSession();
        if (session.getAttribute("LoggedInUser") == null) {
            Executions.sendRedirect("/login.zul");
        }
    }
}
