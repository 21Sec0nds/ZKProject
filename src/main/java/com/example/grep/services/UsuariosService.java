package com.example.grep.services;

import com.example.grep.interfaces.IUsuarios;
import com.example.grep.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioService")
public class UsuariosService  {
    @Autowired
    private IUsuarios usuariosRepository;

    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios getUsuarioById(String id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    public Usuarios getUsuarioByname(String name){ return  usuariosRepository.findByNombreUsuario(name);}

    public Usuarios saveUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public void deleteUsuario(String id) {
        usuariosRepository.deleteById(id);
    }
}