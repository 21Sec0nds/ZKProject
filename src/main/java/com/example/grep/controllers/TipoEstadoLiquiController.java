package com.example.grep.controllers;

import com.example.grep.models.TipoEstadoLiqui;
import com.example.grep.services.TipoEstadoLiquiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoEstadoLiqui")
public class TipoEstadoLiquiController {
    @Autowired
    private TipoEstadoLiquiService tipoEstadoLiquiService;

    @GetMapping("/all")
    public List<TipoEstadoLiqui> getAllTipoEstadoLiqui() {
        return tipoEstadoLiquiService.getAllTipoEstadoLiqui();
    }

    @GetMapping("/{id}")
    public TipoEstadoLiqui getTipoEstadoLiquiById(@PathVariable Integer id) {
        return tipoEstadoLiquiService.getTipoEstadoLiquiById(id);
    }
    @PostMapping("/save")
    public TipoEstadoLiqui saveTipoEstadoLiqui(@RequestBody TipoEstadoLiqui tipoEstadoLiqui) {
        return tipoEstadoLiquiService.saveTipoEstadoLiqui(tipoEstadoLiqui);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTipoEstadoLiqui(@PathVariable Integer id) {
        tipoEstadoLiquiService.deleteTipoEstadoLiqui(id);
    }
}
