package com.example.backend.repositories;

import com.example.backend.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
    // Métodos personalizados para buscar juegos si es necesario
}
