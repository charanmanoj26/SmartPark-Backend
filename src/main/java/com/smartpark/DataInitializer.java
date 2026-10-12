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
        if (parkingRepository.count() == 0) {
            parkingRepository.save(new Parking("A1", "Available"));
            parkingRepository.save(new Parking("A2", "Occupied"));
            parkingRepository.save(new Parking("A3", "Available"));
            parkingRepository.save(new Parking("A4", "Reserved"));
            parkingRepository.save(new Parking("B1", "Occupied"));
            parkingRepository.save(new Parking("B2", "Available"));
        }
    }
}
