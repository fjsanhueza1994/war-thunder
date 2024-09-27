package com.example.ms_aircrafts.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aircraft")
public class Aircraft {

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

}
