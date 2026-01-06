package org.example.servicevoiture.services;

import ch.qos.logback.core.net.server.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {
    @GetMapping("/clients/{id}")
    Client findById(@PathVariable("id") Long id);
}