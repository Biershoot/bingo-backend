package com.example.backend.services;

import com.example.backend.Juego;
import com.example.backend.repositories.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JuegoService {
    @Autowired
    private JuegoRepository juegoRepository;

    public Juego crearNuevoJuego() {
        Juego juego = new Juego();
        juego.setFechaCreacion(LocalDateTime.now());
        juego.setEstado("En espera");
        return juegoRepository.save(juego);
    }

    public List<Juego> obtenerTodosLosJuegos() {
        return juegoRepository.findAll();
    }

    // Otros métodos para gestionar el juego
}
