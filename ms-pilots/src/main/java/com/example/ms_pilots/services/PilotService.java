package com.example.ms_pilots.services;

import com.example.ms_commons.models.entity.Pilot;

import java.util.List;

public interface PilotService {

    public List<Pilot> findAll();
    public Pilot findById(Long id);
    public Pilot save(Pilot pilot);
//    public Pilot update(Pilot pilot, Long id);
    public void deleteById(Long id);
}
