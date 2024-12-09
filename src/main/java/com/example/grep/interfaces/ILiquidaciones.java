package com.example.grep.interfaces;

import com.example.grep.models.Liquidaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILiquidaciones extends JpaRepository<Liquidaciones,Integer> {
}
