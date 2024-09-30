package com.example.ms_commons.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity(name = "pilot")
public class Pilot implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String dni;
    private String address;
    private String city;
    private String country;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Serial
    private static final long serialVersionUID = 2701164234490680414L;
}
