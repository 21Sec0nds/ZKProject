package com.example.grep.services;

import com.example.grep.interfaces.ITipoEstadoLiqui;
import com.example.grep.models.TipoEstadoLiqui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEstadoLiquiService {
    @Autowired
    private ITipoEstadoLiqui tipoEstadoLiquiRepository;

    public List<TipoEstadoLiqui> getAllTipoEstadoLiqui() {
        return tipoEstadoLiquiRepository.findAll();
    }

    public TipoEstadoLiqui getTipoEstadoLiquiById(Integer id) {
        return tipoEstadoLiquiRepository.findById(id).orElse(null);
    }

    public TipoEstadoLiqui saveTipoEstadoLiqui(TipoEstadoLiqui tipoEstadoLiqui) {
        return tipoEstadoLiquiRepository.save(tipoEstadoLiqui);
    }

    public void deleteTipoEstadoLiqui(Integer id) {
        tipoEstadoLiquiRepository.deleteById(id);
    }
}
