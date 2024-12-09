package com.example.grep.services;

import com.example.grep.interfaces.IPresupuesto;
import com.example.grep.models.Presupuestos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestosService {
    @Autowired
    private IPresupuesto presupuestoRepository;

    public List<Presupuestos> getAllPresupuestos() {
        return presupuestoRepository.findAll();
    }

    public Presupuestos getPresupuestoById(Integer id) {
        return presupuestoRepository.findById(id).orElse(null);
    }

    public Presupuestos savePresupuesto(Presupuestos presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    public void deletePresupuesto(Integer id) {
        presupuestoRepository.deleteById(id);
    }
}
