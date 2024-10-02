package com.example.ms_pilotaircraft.controller;

import com.example.ms_pilotaircraft.models.dao.PilotAircraftDao;
import com.example.ms_pilotaircraft.models.entity.PilotAircraft;
import com.example.ms_pilotaircraft.services.PilotAircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PilotAircraftServiceImpl implements PilotAircraftService {
    private final PilotAircraftDao pilotAircraftDao;

    @Autowired
    public PilotAircraftServiceImpl(PilotAircraftDao pilotAircraftDao) {
        this.pilotAircraftDao = pilotAircraftDao;
    }

    @Override
    public PilotAircraft assignPilotToAircraft(PilotAircraft pilotAircraft) {
        return pilotAircraftDao.save(pilotAircraft);
    }

    @Override
    public Optional<PilotAircraft> getPilotAircraft(Long id) {
        return pilotAircraftDao.findById(id);
    }

    @Override
    public void unassignPilotFromAircraft(Long id) {
        pilotAircraftDao.deleteById(id);
    }

    @Override
    public void isPilotOrAircraftAssigned(Long idPilot, Long idAircraft) throws Exception {
        boolean pilotExists = pilotAircraftDao.existsByPilotId(idPilot);
        boolean aircraftExists = pilotAircraftDao.existsByAircraftId(idAircraft);

        if (pilotExists && aircraftExists) {
            throw new Exception("Tanto el piloto como el avión están asignados.");
        } else if (pilotExists) {
            throw new Exception("El piloto ya está asignado.");
        } else if (aircraftExists) {
            throw new Exception("El avión ya está asignado.");
        }
    }
}