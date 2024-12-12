package com.example.grep.services;

import com.example.grep.interfaces.IGastos;
import com.example.grep.models.Gastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("gastosService")
public class GastosService {

    @Autowired
    private IGastos gastosRepository;

    public List<Gastos> getAllGastos() {
        return gastosRepository.findAll();
    }

    public Gastos getGastos(Integer id) {
        return gastosRepository.findById(id).orElse(null);
    }
    public Gastos saveGastos(Gastos gastos) {
        return gastosRepository.save(gastos);
    }

    public void deleteGastos(Integer id) {
        gastosRepository.deleteById(id);
    }

    public List<Gastos> getGastosByFilters(int departamentoId, String finalidadId, int anio) {
        List<Gastos> allGastos = gastosRepository.findAll();

        return allGastos.stream()
                .filter(g -> g.getDepartamento() != null && g.getDepartamento().getIdDepartamento() == departamentoId)
                .filter(g -> g.getFinalidad() != null && g.getFinalidad().getIdFinalidad() == finalidadId)
                .filter(g -> g.getAnio() == anio)
                .collect(Collectors.toList());
    }
}
