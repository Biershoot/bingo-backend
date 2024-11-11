package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Método para enviar la balota a todos los clientes conectados
    public void enviarBalota(int numero) {
        messagingTemplate.convertAndSend("/topic/balotas", "Balota sacada: " + numero); // Enviamos al canal "/topic/balotas"
    }
}
