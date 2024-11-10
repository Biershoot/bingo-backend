package com.example.backend.services;

import com.example.backend.Resultado;
import com.example.backend.repositories.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoService {
    @Autowired
    private ResultadoRepository resultadoRepository;

    public List<Resultado> obtenerResultados() {
        return resultadoRepository.findAll();
    }

    // Métodos para guardar y gestionar resultados
}
