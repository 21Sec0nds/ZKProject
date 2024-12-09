package com.example.grep.viewModels;

import com.example.grep.models.Liquidaciones;
import com.example.grep.services.LiquidacionesService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class LiquidacionesVM {

    @WireVariable
    private LiquidacionesService liquidacionesService;

    private List<Liquidaciones> liquidaciones;
    private Integer idLiquidacion;
    private Integer Mes;
    private Integer Anio;
    private Integer idDepartamento;
    private Integer idEstado;

    @Init
    public void init() {
        //Manual injection
        liquidacionesService = (LiquidacionesService) SpringUtil.getBean("liquidacionService");
        liquidaciones = new ListModelList<>(liquidacionesService.getAllLiquidaciones());
    }

    public List<Liquidaciones> getLiquidaciones() {
        return liquidaciones;
    }
    public Integer getLiquidacion() {
        return idLiquidacion;}
    public  Integer getMes(){return Mes;}
    public Integer getAnio(){return Anio;}
    public  Integer getIdDepartamento(){return idDepartamento;}
    public Integer getIdEstado(){return idEstado;}
}
