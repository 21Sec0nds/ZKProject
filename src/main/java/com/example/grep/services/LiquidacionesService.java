package com.example.grep.services;

import com.example.grep.interfaces.ILiquidaciones;
import com.example.grep.models.Liquidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiquidacionesService {
    @Autowired
    private ILiquidaciones liquidacionesRepository;

    public List<Liquidaciones> getAllLiquidaciones() {
        return liquidacionesRepository.findAll();
    }

    public Liquidaciones getLiquidacionesById(Integer id) {
        return liquidacionesRepository.findById(id).orElse(null);
    }

    public Liquidaciones saveLiquidaciones(Liquidaciones liquidaciones) {
        return liquidacionesRepository.save(liquidaciones);
    }

    public void deleteLiquidaciones(Integer id) {
        liquidacionesRepository.deleteById(id);
    }
}
