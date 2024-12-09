package com.example.grep.controllers;

import com.example.grep.models.Usuarios;
import com.example.grep.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/all")
    public List<Usuarios> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuarios getUsuarioById(@PathVariable String id) {
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping("/save")
    public Usuarios saveUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.saveUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuariosService.deleteUsuario(id);
    }
}
