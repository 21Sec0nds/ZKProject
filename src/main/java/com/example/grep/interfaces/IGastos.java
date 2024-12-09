package com.example.grep.interfaces;

import com.example.grep.models.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGastos extends JpaRepository<Gastos,Integer> {

}
