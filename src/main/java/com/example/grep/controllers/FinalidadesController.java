package com.example.grep.controllers;

import com.example.grep.models.Finalidades;
import com.example.grep.services.FinalidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/finalidades")
public class FinalidadesController {
    @Autowired
    private FinalidadesService finalidadesService;

    @GetMapping("/all")
    public List<Finalidades> getAllTipoEstadoLiqui() {
        return finalidadesService.getAllFinalidades();
    }

    @GetMapping("/{id}")
    public Finalidades getTipoEstadoLiquiById(@PathVariable String id) {
        return finalidadesService.getFinalidades(id);
    }
    @PostMapping("/save")
    public Finalidades saveTipoEstadoLiqui(@RequestBody Finalidades finalidades) {
        return finalidadesService.saveFinalidades(finalidades);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTipoEstadoLiqui(@PathVariable String id) {
        finalidadesService.deleteFinalidades(id);
    }
}