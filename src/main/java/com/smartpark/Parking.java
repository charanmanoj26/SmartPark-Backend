package com.smartpark;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slot;
    private String status;
    private String vehicleNumber;

    public Parking() {
    }

    public Parking(String slot, String status) {
    this.slot = slot;
    this.status = status;
}

public String getVehicleNumber() {
    return vehicleNumber;
}

public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
}

    public Long getId() {
        return id;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
