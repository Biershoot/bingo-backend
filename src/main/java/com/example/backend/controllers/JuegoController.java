package com.example.backend.controllers;

import com.example.backend.Juego;
import com.example.backend.models.Tarjeton;
import com.example.backend.services.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @PostMapping("/crear")
    public ResponseEntity<Juego> crearNuevoJuego() {
        Juego nuevoJuego = juegoService.crearNuevoJuego();
        return ResponseEntity.ok(nuevoJuego);
    }

    @GetMapping
    public ResponseEntity<List<Juego>> obtenerTodosLosJuegos() {
        List<Juego> juegos = juegoService.obtenerTodosLosJuegos();
        return ResponseEntity.ok(juegos);

    }

}

