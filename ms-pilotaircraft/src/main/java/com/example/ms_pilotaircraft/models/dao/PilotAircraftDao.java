package com.example.ms_pilotaircraft.models.dao;

import com.example.ms_pilotaircraft.models.entity.PilotAircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotAircraftDao extends JpaRepository<PilotAircraft, Long> {
    boolean existsByPilotId(Long pilotId);
    boolean existsByAircraftId(Long aircraftId);
}
