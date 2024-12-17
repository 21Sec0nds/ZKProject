package com.example.grep.interfaces;

import com.example.grep.models.Departamentos;
import com.example.grep.models.Finalidades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentos extends JpaRepository<Departamentos, Integer> {
    Departamentos findByNombreDepartamento(String nombreDepartamento);
}
