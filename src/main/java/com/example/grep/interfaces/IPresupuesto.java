package com.example.grep.interfaces;

import com.example.grep.models.Presupuestos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPresupuesto extends JpaRepository<Presupuestos, Integer> {
}
