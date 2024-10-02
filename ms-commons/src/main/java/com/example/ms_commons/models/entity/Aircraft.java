package com.example.ms_commons.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity(name = "aircraft")
public class Aircraft implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String model;
    private String registration;
    private String manufacturer;

    @JsonProperty("manufactured_year")
    @Column(name = "manufactured_year")
    private int manufacturedYear;

    private int seats;

    @JsonProperty("flying_hours")
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
    private static final long serialVersionUID = -1149937310139952161L;
}
