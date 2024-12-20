package com.example.grep.viewModels;

import com.example.grep.models.Gastos;
import com.example.grep.services.GastosService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class GastosVM {
    @WireVariable
    private GastosService gastosService;

    private List<Gastos> gastos;
    private Integer idGasto;
    private Integer idGastosDepartamento;
    private String idFinalidad;
    private Integer Mes;
    private Integer Anio;
    private Double Importe;
    private String Description;
    private String Justificante;

    @Init
    public void init() {
        //Manual injection
        gastosService = (GastosService) SpringUtil.getBean("gastoService");
        gastos = new ListModelList<>(gastosService.getAllGastos());
    }

    public List<Gastos> getGastos() {
        return gastos;
    }
    public Integer getIdGasto(){return idGasto;}
    public Integer getIdGastosDepartamento() {return idGastosDepartamento;}
    public String getIdFinalidad() {return idFinalidad;}
    public  Integer getMes(){return Mes;}
    public Integer getAnio(){return Anio;}
    public Double getImporte(){return Importe;}
    public String getDescription(){return Description;}
    public String getJustificante(){return Justificante;}
}
