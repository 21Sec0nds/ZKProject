package com.example.grep.controllers;

import com.example.grep.models.Presupuestos;
import com.example.grep.services.PresupuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presupuestos")
public class PresupuestosController {

    @Autowired
    private PresupuestosService presupuestosService;

    @GetMapping
    public List<Presupuestos> getAllPresupuestos() {
        return presupuestosService.getAllPresupuestos();
    }

    @GetMapping("/{id}")
    public Presupuestos getPresupuestoById(@PathVariable Integer id) {
        return presupuestosService.getPresupuestoById(id);
    }

    @PostMapping
    public Presupuestos savePresupuesto(@RequestBody Presupuestos presupuesto) {
        return presupuestosService.savePresupuesto(presupuesto);
    }

    @DeleteMapping("/{id}")
    public void deletePresupuesto(@PathVariable Integer id) {
        presupuestosService.deletePresupuesto(id);
    }
}