package com.example.ms_pilots.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pilot {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String address;
    private String city;
    private String country;

}