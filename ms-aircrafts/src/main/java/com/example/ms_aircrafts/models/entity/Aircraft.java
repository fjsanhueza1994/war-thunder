package com.example.ms_aircrafts.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String model;
    private String manufacturer;
    private int year;
    private int seats;

}
