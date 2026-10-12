package com.smartpark;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slot;
    private String vehicleNumber;
    private String bookingTime;
    private String status;

    public Booking() {
    }

    public Booking(String slot, String vehicleNumber,
        String bookingTime, String status) {
        this.slot = slot;
        this.vehicleNumber = vehicleNumber;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getSlot() {
        return slot;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
