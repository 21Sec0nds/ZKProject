package com.example.grep.services;

import com.example.grep.interfaces.IPresupuesto;
import com.example.grep.models.Presupuestos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Presupuestos>getPresupuestoByFinalidad(String findalidad){
        List<Presupuestos> lista = getAllPresupuestos();
        return lista.stream()
                .filter( presupuesto -> presupuesto.getIdFinalidad().getIdFinalidad().equals(findalidad))
                .collect(Collectors.toList());
    }
}
