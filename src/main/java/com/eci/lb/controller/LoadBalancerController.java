package com.eci.lb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoadBalancerController {
    private final List<String> servers = new ArrayList<>();
    private int currentIndex = 0;

    public LoadBalancerController() {
        // Agrega aquí las direcciones de tus servidores de destino
        servers.add("http://localhost:34001/hello");
        servers.add("http://localhost:34002/hello");
        servers.add("http://localhost:34003/hello");
    }

    @GetMapping("/balance")
    public String balanceRequest() {
        String server = getNextServer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(server, String.class);
        return response.getBody();
    }

    private synchronized String getNextServer() {
        if (currentIndex >= servers.size()) {
            currentIndex = 0;
        }
        String nextServer = servers.get(currentIndex);
        currentIndex++;
        return nextServer;
    }
}
