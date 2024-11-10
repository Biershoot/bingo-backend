package com.example.backend.services;

import com.example.backend.Juego;
import com.example.backend.repositories.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Service
public class JuegoService {
    @Autowired
    private JuegoRepository juegoRepository;

    private final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    private ScheduledFuture<?> future;

    public JuegoService() {
        scheduler.initialize();
    }

    // Crear un nuevo juego y guardarlo en la base de datos
    public Juego crearNuevoJuego() {
        Juego juego = new Juego();
        juego.setFechaCreacion(LocalDateTime.now());
        juego.setEstado("En espera");
        return juegoRepository.save(juego);
    }

    // Obtener todos los juegos de la base de datos
    public List<Juego> obtenerTodosLosJuegos() {
        return juegoRepository.findAll();
    }

    // Iniciar un juego con una espera de 30 segundos
    public void iniciarJuegoConEspera(Juego juego) {
        future = scheduler.schedule(() -> {
            // Lógica para comenzar el juego después de la espera
            juego.setEstado("En juego");
            juegoRepository.save(juego); // Guardar el estado del juego en la base de datos
            System.out.println("¡El juego ha comenzado!");
            // Aquí puedes llamar a otros métodos para iniciar el juego
        }, new java.util.Date(System.currentTimeMillis() + 30000)); // 30 segundos
    }

    // Cancelar la espera si es necesario
    public void cancelarEspera() {
        if (future != null) {
            future.cancel(false);
        }
    }
}
