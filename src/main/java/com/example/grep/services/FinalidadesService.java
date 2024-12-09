package com.example.grep.services;

import com.example.grep.interfaces.IFinalidades;
import com.example.grep.models.Finalidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalidadesService {
    @Autowired
    private IFinalidades finalidadesRepository;

    public List<Finalidades> getAllFinalidades() {
        return finalidadesRepository.findAll();
    }

    public Finalidades getFinalidades(String id) {
        return finalidadesRepository.findById(id).orElse(null);
    }

    public Finalidades saveFinalidades(Finalidades finalidades) {
        return finalidadesRepository.save(finalidades);
    }

    public void deleteFinalidades(String id) {
        finalidadesRepository.deleteById(id);
    }
}
