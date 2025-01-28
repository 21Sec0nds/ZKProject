package com.example.grep.interfaces;
import com.example.grep.models.Finalidades;
import com.example.grep.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarios extends JpaRepository<Usuarios, String> {
    Usuarios findByNombreUsuario(String nombreUsuario);
}