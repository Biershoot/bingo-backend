package com.example.backend.repositories;

import com.example.backend.Balota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalotaRepository extends JpaRepository<Balota, Long> {
    // Puedes agregar métodos personalizados aquí
}
