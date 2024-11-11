package com.example.backend.controllers;

import com.example.backend.models.Tarjeton;
import com.example.backend.services.TarjetonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/juegos")
public class TarjetonController {

    @Autowired
    private TarjetonService tarjetonService;

    @GetMapping("/tarjeton")
    public ResponseEntity<Tarjeton> obtenerTarjeton() {
        Tarjeton tarjeton = tarjetonService.generarTarjeton();
        return ResponseEntity.ok(tarjeton);
    }
}

