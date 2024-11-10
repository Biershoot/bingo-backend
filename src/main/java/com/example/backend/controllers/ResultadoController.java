package com.example.backend.controllers;

import com.example.backend.Resultado;
import com.example.backend.services.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping
    public ResponseEntity<List<Resultado>> obtenerResultados() {
        List<Resultado> resultados = resultadoService.obtenerResultados();
        return ResponseEntity.ok(resultados);
    }

    // Otros endpoints para gestionar los resultados
}
