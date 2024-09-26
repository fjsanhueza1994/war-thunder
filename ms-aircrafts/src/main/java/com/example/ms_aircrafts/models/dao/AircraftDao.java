package com.example.ms_aircrafts.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ms_aircrafts.models.entity.Aircraft;

@Repository
public interface AircraftDao extends CrudRepository<Aircraft, Long> {
    
}