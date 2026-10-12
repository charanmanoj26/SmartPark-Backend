package com.smartpark;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {
    "http://localhost:5173",
"https://smartpark-frontend-rq0t.onrender.com"
})
public class ParkingController {

    @GetMapping("/api/parking")
    public List<Map<String, Object>> getParkingSlots() {
        return List.of(
            Map.of("id", 1, "slot", "A1", "status", "Available"),
            Map.of("id", 2, "slot", "A2", "status", "Occupied"),
            Map.of("id", 3, "slot", "A3", "status", "Available"),
            Map.of("id", 4, "slot", "A4", "status", "Reserved"),
            Map.of("id", 5, "slot", "B1", "status", "Occupied"),
            Map.of("id", 6, "slot", "B2", "status", "Available")
        );
    }
}
