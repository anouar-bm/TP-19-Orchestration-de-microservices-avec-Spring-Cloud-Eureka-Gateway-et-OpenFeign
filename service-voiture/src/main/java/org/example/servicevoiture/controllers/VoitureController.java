package org.example.servicevoiture.controllers;

import lombok.RequiredArgsConstructor;
import org.example.servicevoiture.entity.Voiture;
import org.example.servicevoiture.repositories.VoitureRepository;
import org.example.servicevoiture.services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voitures")
public class VoitureController {

    private final VoitureRepository voitureRepo;
    private final ClientService clientService;

    @GetMapping
    public List<Voiture> findAll() {
        return voitureRepo.findAll().stream()
                .peek(v -> v.setClient(clientService.findById(v.getClientId())))
                .toList();
    }

    @GetMapping("/{id}")
    public Voiture findById(@PathVariable Long id) {
        Voiture v = voitureRepo.findById(id).orElseThrow();
        v.setClient(clientService.findById(v.getClientId()));
        return v;
    }

    @GetMapping("/client/{clientId}")
    public List<Voiture> findByClient(@PathVariable Long clientId) {
        return voitureRepo.findByClientId(clientId);
    }
}
