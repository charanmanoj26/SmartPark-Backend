package com.smartpark;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ParkingRepository parkingRepository;

    public DataInitializer(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public void run(String... args) {
        parkingRepository.findBySlot("A1")
    .ifPresent(p -> {
        p.setStatus("Available");
        parkingRepository.save(p);
    });

parkingRepository.findBySlot("A2")
    .ifPresent(p -> {
        p.setStatus("Occupied");
        parkingRepository.save(p);
    });

parkingRepository.findBySlot("A3")
    .ifPresent(p -> {
        p.setStatus("Available");
        parkingRepository.save(p);
    });

parkingRepository.findBySlot("A4")
    .ifPresent(p -> {
        p.setStatus("Reserved");
        parkingRepository.save(p);
    });

parkingRepository.findBySlot("B1")
    .ifPresent(p -> {
        p.setStatus("Occupied");
        parkingRepository.save(p);
    });

parkingRepository.findBySlot("B2")
    .ifPresent(p -> {
        p.setStatus("Available");
        parkingRepository.save(p);
    });
    }
}
