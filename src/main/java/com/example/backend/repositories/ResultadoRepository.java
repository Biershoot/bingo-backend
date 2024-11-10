package com.example.backend.repositories;

import com.example.backend.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
    // Métodos personalizados si es necesario
}
