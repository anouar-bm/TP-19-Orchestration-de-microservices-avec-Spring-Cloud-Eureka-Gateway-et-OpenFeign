package org.example.servicevoiture;

import org.example.servicevoiture.entity.Voiture;
import org.example.servicevoiture.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ServiceVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVoitureApplication.class, args);
    }
    @Bean
    CommandLineRunner start(VoitureRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    new Voiture(null, "Toyota", "A123", "Corolla", 1L, null),
                    new Voiture(null, "Renault", "B456", "Clio", 1L, null),
                    new Voiture(null, "Peugeot", "C789", "308", 2L, null)
            ));
        };
    }
}
