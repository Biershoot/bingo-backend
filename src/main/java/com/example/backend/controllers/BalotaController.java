package com.example.backend.controllers;

import com.example.backend.Balota;
import com.example.backend.services.BalotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balotas")
public class BalotaController {

    @Autowired
    private BalotaService balotaService;

    @PostMapping("/generar")
    public ResponseEntity<String> generarBalotas() {
        balotaService.generarBalotas();
        return ResponseEntity.ok("Balotas generadas con éxito");
    }

    @GetMapping
    public ResponseEntity<List<Balota>> obtenerBalotas() {
        List<Balota> balotas = balotaService.obtenerBalotas();
        return ResponseEntity.ok(balotas);
    }
}

