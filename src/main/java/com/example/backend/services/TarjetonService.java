package com.example.backend.services;

import com.example.backend.models.Tarjeton;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class TarjetonService {
    // Otros métodos y atributos...

    public Tarjeton generarTarjeton() {
        Tarjeton tarjeton = new Tarjeton();
        Random random = new Random();

        // Generar números únicos para cada columna
        tarjeton.setColumnaB(generarNumerosUnicos(random, 1, 15));
        tarjeton.setColumnaI(generarNumerosUnicos(random, 16, 30));
        tarjeton.setColumnaN(generarNumerosUnicos(random, 31, 45));
        tarjeton.setColumnaG(generarNumerosUnicos(random, 46, 60));
        tarjeton.setColumnaO(generarNumerosUnicos(random, 61, 75));

        return tarjeton;
    }

    private List<Integer> generarNumerosUnicos(Random random, int min, int max) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros, random); // Mezclar los números
        return numeros.subList(0, 5); // Seleccionar los primeros 5 números
    }
}
