package com.eci.lb.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping("/balance")
    public String balanceRequest(@RequestBody String cadena) {
        String server = getNextServer();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/plain");
        HttpEntity<String> requestEntity = new HttpEntity<>(cadena, headers);
        ResponseEntity<String> response = restTemplate.exchange(server, HttpMethod.PUT, requestEntity, String.class);
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
