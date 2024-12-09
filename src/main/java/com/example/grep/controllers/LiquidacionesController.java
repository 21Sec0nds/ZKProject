package com.example.grep.controllers;

import com.example.grep.models.Liquidaciones;
import com.example.grep.services.LiquidacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liquidaciones")
public class LiquidacionesController {

    @Autowired
    private LiquidacionesService liquidacionesService;

    @GetMapping
    public List<Liquidaciones> getAllLiquidaciones() {
        return liquidacionesService.getAllLiquidaciones();
    }

    @GetMapping("/{id}")
    public Liquidaciones getLiquidacionesById(@PathVariable Integer id) {
        return liquidacionesService.getLiquidacionesById(id);
    }

    @PostMapping
    public Liquidaciones saveLiquidaciones(@RequestBody Liquidaciones liquidaciones) {
        return liquidacionesService.saveLiquidaciones(liquidaciones);
    }

    @DeleteMapping("/{id}")
    public void deleteLiquidaciones(@PathVariable Integer id) {
        liquidacionesService.deleteLiquidaciones(id);
    }
}