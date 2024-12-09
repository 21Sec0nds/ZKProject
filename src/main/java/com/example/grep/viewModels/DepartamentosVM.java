package com.example.grep.viewModels;

import com.example.grep.models.Departamentos;
import com.example.grep.services.DepartamentosService;
import org.zkoss.bind.annotation.*;
import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.*;


import java.util.List;

public class DepartamentosVM {

    @WireVariable
    private DepartamentosService departamentoService;

    private List<Departamentos> departamentos;
    private String idDepartamento;
    private String nombreDepartamento;

    @Init
    public void init() {
        departamentos = new ListModelList<>(departamentoService.getAllDepartamentos());
    }

    public List<Departamentos> getDepartamentos() {
        return departamentos;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }


    public String getNombreDepartamento() {
        return nombreDepartamento;
    }



}
