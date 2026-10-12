package com.smartpark;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://smartpark-frontend-rq0t.onrender.com"
})
public class ParkingController {

    private final ParkingRepository parkingRepository;
    private final BookingRepository bookingRepository;

    public ParkingController(
        ParkingRepository parkingRepository,
        BookingRepository bookingRepository) {
    this.parkingRepository = parkingRepository;
    this.bookingRepository = bookingRepository;
}

    @GetMapping("/api/parking")
    public List<Parking> getParkingSlots() {
        return parkingRepository.findAll();
    }
    @GetMapping("/api/bookings")
    public List<Booking> getBookings() {
        return bookingRepository.findByStatus("Active");
    }
    @PostMapping("/api/parking/{slot}/reserve")
    public Parking reserveSlot(
        @PathVariable("slot") String slot,
        @RequestParam("vehicleNumber") String vehicleNumber) {

    Parking parking = parkingRepository.findBySlot(slot)
        .orElseThrow(() -> new RuntimeException("Parking slot not found"));

    if (!parking.getStatus().equals("Available")) {
        throw new RuntimeException("Parking slot is not available");
    }

        parking.setStatus("Reserved");
        parking.setVehicleNumber(vehicleNumber);
        parking.setVehicleNumber(vehicleNumber);
        parkingRepository.save(parking);
        Booking booking = new Booking(
            slot,
            vehicleNumber,
            LocalDateTime.now().toString(),
            "Active"
        );
        bookingRepository.save(booking);
        return parking;
    }
    @PutMapping("/api/bookings/{id}/cancel")
    public Booking cancelBooking(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Booking not found"));
        if (booking.getStatus().equals("Active")) {
            booking.setStatus("Cancelled");
            bookingRepository.save(booking);
            parkingRepository.findBySlot(booking.getSlot())
            .ifPresent(parking -> {
                parking.setStatus("Available");
                parking.setVehicleNumber(null);
                parkingRepository.save(parking);
            });
        }
        return booking;
    }
}
