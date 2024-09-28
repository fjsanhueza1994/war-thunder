package com.example.ms_commons.models.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "aircraft")
public class Aircraft implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String model;
    private String registration;
    private String manufacturer;
    @Column(name = "manufactured_year")
    private int manufacturedYear;
    private int seats;
    @Column(name = "flying_hours")
    private int flyingHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getFlyingHours() {
        return flyingHours;
    }

    public void setFlyingHours(int flyingHours) {
        this.flyingHours = flyingHours;
    }

    @Serial
    private static final long serialVersionUID = -2789629226047901188L;

}
