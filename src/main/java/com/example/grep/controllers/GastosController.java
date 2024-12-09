package com.example.grep.controllers;

import com.example.grep.models.Gastos;
import com.example.grep.services.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastosController {

    @Autowired
    private GastosService gastosService;

    @GetMapping("/all")
    public ResponseEntity<List<Gastos>> getAlldepartamentos() {
        List<Gastos> gastosList = gastosService.getAllGastos();
        return ResponseEntity.ok(gastosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gastos> getDepartamentos(@PathVariable Integer id) {
        Gastos gastos = gastosService.getGastos(id);
        return ResponseEntity.ok(gastos);
    }

    @PostMapping("/save")
    public ResponseEntity<Gastos> saveDepartamentos(@RequestBody Gastos gastos) {
        Gastos savedGastos = gastosService.saveGastos(gastos);
        return ResponseEntity.ok(savedGastos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartamentos(@PathVariable Integer id) {
        gastosService.deleteGastos(id);
        return ResponseEntity.noContent().build();
    }
}
