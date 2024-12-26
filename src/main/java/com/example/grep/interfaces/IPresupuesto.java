package com.example.grep.interfaces;
import com.example.grep.models.Presupuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPresupuesto extends JpaRepository<Presupuestos, Integer> {
}
