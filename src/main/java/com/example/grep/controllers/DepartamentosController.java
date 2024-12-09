package com.example.grep.controllers;

import com.example.grep.models.Departamentos;
import com.example.grep.services.DepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentosController {

    @Autowired
    private DepartamentosService departamentosService;

    @GetMapping("/all")
    public List<Departamentos> getAlldepartamentos() {
        return departamentosService.getAllDepartamentos();
    }

    @GetMapping("/{id}")
    public Departamentos getDepartamentos(@PathVariable Integer id) {
        return departamentosService.getDepartamentos(id);
    }
    @PostMapping("/save")
    public Departamentos saveDepartamentos(@RequestBody Departamentos departamentos) {
        return departamentosService.saveDepartamentos(departamentos);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDepartamentos(@PathVariable Integer id) {
        departamentosService.deleteDepartamentos(id);
    }


}