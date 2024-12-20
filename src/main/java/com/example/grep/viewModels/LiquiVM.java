package com.example.grep.viewModels;

import com.example.grep.models.TipoEstadoLiqui;
import com.example.grep.services.TipoEstadoLiquiService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class LiquiVM {

    @WireVariable
    private TipoEstadoLiquiService liquiService;

    private List<TipoEstadoLiqui> liquidacis;
    private Integer idEstado;
    private String nameEstado;

    @Init
    public void init() {

        liquiService = (TipoEstadoLiquiService) SpringUtil.getBean("EstadoLiqui");
        if (liquiService != null) {
            liquidacis = new ListModelList<>(liquiService.getAllTipoEstadoLiqui());
        } else {
            liquidacis = new ListModelList<>();
        }
    }

    public List<TipoEstadoLiqui> getLiquidacis() {
        return liquidacis;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public String getNameEstado() {
        return nameEstado;
    }

}
