package com.example.ms_aircrafts.services;

import java.util.List;

import com.example.ms_commons.models.entity.Aircraft;

public interface AircraftService {

    public List<Aircraft> findAll();
    public Aircraft findById(Long id);
    public Aircraft save(Aircraft aircraft);
    public void deleteById(Long id);
    
}
