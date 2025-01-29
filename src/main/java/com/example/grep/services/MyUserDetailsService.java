package com.example.grep.services;

import java.util.ArrayList;

import com.example.grep.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsuariosService usuarioService;

    public MyUserDetailsService() {
    }@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios usuario = usuarioService.getUsuarioByname(username);

        // Check if the user exists and password matches
        if (usuario == null) {
            // Set user in session
            throw new UsernameNotFoundException("User with username - " + username + " not found");
        }


        return new User(usuario.getNombreUsuario(), usuario.getPassword(), new ArrayList<>());
    }


}
