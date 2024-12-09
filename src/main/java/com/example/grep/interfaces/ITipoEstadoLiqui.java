package com.example.grep.interfaces;


import com.example.grep.models.TipoEstadoLiqui;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITipoEstadoLiqui extends JpaRepository<TipoEstadoLiqui, Integer> {

}
