package com.example.grep.interfaces;

import com.example.grep.models.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGastos extends JpaRepository<Gastos,Integer> {

    @Query("SELECT g FROM Gastos g WHERE g.anio = :anio AND g.mes = :mes")
    List<Gastos> findByAnioAndMes(@Param("anio") int anio, @Param("mes") String mes);
}
