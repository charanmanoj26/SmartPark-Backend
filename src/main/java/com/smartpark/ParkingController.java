package com.smartpark;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://smartpark-frontend-rq0t.onrender.com"
})
public class ParkingController {

    private final ParkingRepository parkingRepository;

    public ParkingController(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @GetMapping("/api/parking")
    public List<Parking> getParkingSlots() {
        return parkingRepository.findAll();
    }

    @PostMapping("/api/parking/{slot}/reserve")
    public Parking reserveSlot(@PathVariable String slot) {
        Parking parking = parkingRepository.findBySlot(slot)
            .orElseThrow(() -> new RuntimeException("Parking slot not found"));

        if (!parking.getStatus().equals("Available")) {
            throw new RuntimeException("Parking slot is not available");
        }

        parking.setStatus("Occupied");
        return parkingRepository.save(parking);
    }
}
