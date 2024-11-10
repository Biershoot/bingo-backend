package com.example.backend.services;

import com.example.backend.Balota;
import com.example.backend.repositories.BalotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BalotaService {
    @Autowired
    private BalotaRepository balotaRepository;

    // Usamos un ScheduledExecutorService para manejar la ejecución periódica
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // Generar todas las balotas y guardarlas en la base de datos
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

    // Obtener todas las balotas desde la base de datos
    public List<Balota> obtenerBalotas() {
        return balotaRepository.findAll();
    }

    // Iniciar el sorteo de balotas, sacando una balota aleatoria cada 5 segundos
    public void iniciarSorteoDeBalotas() {
        scheduler.scheduleAtFixedRate(() -> {
            // Lógica para sacar una balota aleatoria y marcarla como sacada
            List<Balota> balotasNoSacadas = balotaRepository.findAll().stream()
                    .filter(balota -> !balota.isSacada()) // Filtrar balotas no sacadas
                    .collect(Collectors.toList());

            if (!balotasNoSacadas.isEmpty()) {
                Random random = new Random();
                Balota balotaSacada = balotasNoSacadas.get(random.nextInt(balotasNoSacadas.size())); // Seleccionar una balota aleatoria
                balotaSacada.setSacada(true);
                balotaRepository.save(balotaSacada); // Guardar la balota como sacada

                System.out.println("Balota sacada: " + balotaSacada.getNumero());
                // Aquí podrías agregar lógica adicional, como enviar actualizaciones a los jugadores.
            } else {
                System.out.println("No hay más balotas disponibles para sacar.");
                detenerSorteoDeBalotas(); // Detener el sorteo si no hay más balotas
            }
        }, 0, 5, TimeUnit.SECONDS); // 0 segundos de espera inicial, y cada 5 segundos
    }

    // Detener el sorteo de balotas
    public void detenerSorteoDeBalotas() {
        scheduler.shutdown(); // Detener el scheduler
    }

    // Otros métodos para gestionar las balotas
}

