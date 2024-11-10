package com.example.backend.services;

import com.example.backend.Balota;
import com.example.backend.repositories.BalotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BalotaService {
    @Autowired
    private BalotaRepository balotaRepository;

    public void generarBalotas() {
        List<Balota> balotas = IntStream.rangeClosed(1, 75)
                .mapToObj(numero -> {
                    Balota balota = new Balota();
                    balota.setNumero(numero);
                    balota.setSacada(false);
                    return balota;
                }).collect(Collectors.toList());

        balotaRepository.saveAll(balotas);
    }

    public List<Balota> obtenerBalotas() {
        return balotaRepository.findAll();
    }

    // Otros métodos para gestionar las balotas
}
