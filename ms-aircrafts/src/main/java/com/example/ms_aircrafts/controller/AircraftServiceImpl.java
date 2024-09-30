package com.example.ms_aircrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_aircrafts.models.dao.AircraftDao;
import com.example.ms_commons.models.entity.Aircraft;
import com.example.ms_aircrafts.services.AircraftService;

@Service
public class AircraftServiceImpl implements AircraftService {

    private final AircraftDao aircraftDao;

    @Autowired
    public AircraftServiceImpl(AircraftDao aircraftDao) {
        this.aircraftDao = aircraftDao;
    }

    @Override
    public List<Aircraft> findAll() {
        return (List<Aircraft>) aircraftDao.findAll();
    }

    @Override
    public Aircraft findById(Long id) {
        return aircraftDao.findById(id).orElse(null);
    }

    @Override
    public Aircraft save(Aircraft aircraft) {
        return aircraftDao.save(aircraft);
    }

    @Override
    public void deleteById(Long id) {
        aircraftDao.deleteById(id);
    }
    
}
