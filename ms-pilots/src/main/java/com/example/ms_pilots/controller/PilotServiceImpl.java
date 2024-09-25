package com.example.ms_pilots.controller;

import com.example.ms_pilots.models.dao.PilotDao;
import com.example.ms_pilots.models.entity.Pilot;
import com.example.ms_pilots.services.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotServiceImpl implements PilotService {

    private final PilotDao pilotDao;

    @Autowired
    public PilotServiceImpl(PilotDao pilotDao) {
        this.pilotDao = pilotDao;
    }

    @Override
    public List<Pilot> findAll() {
        return (List<Pilot>) pilotDao.findAll();
    }

    @Override
    public Pilot findById(Long id) {
        return pilotDao.findById(id).orElse(null);
    }

    @Override
    public Pilot save(Pilot pilot) {
        return pilotDao.save(pilot);
    }

    @Override
    public void deleteById(Long id) {
        pilotDao.deleteById(id);
    }
}
