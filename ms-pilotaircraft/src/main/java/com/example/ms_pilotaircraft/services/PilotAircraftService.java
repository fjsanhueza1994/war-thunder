package com.example.ms_pilotaircraft.services;

import com.example.ms_pilotaircraft.models.entity.PilotAircraft;

import java.util.Optional;

public interface PilotAircraftService {
    PilotAircraft assignPilotToAircraft(PilotAircraft pilotAircraft);
    Optional<PilotAircraft> getPilotAircraft(Long id);
    void unassignPilotFromAircraft(Long id);
    void isPilotOrAircraftAssigned(Long idPilot, Long idAircraft) throws Exception;
}
