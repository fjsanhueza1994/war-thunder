package com.example.ms_pilotaircraft.models.dto;

import com.example.ms_pilotaircraft.models.entity.PilotAircraft;

public class AssignPilotAircraftResponse {
    private String message;
    private PilotAircraft pilotAircraft;

    public AssignPilotAircraftResponse(String message, PilotAircraft pilotAircraft) {
        this.message = message;
        this.pilotAircraft = pilotAircraft;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PilotAircraft getPilotAircraft() {
        return pilotAircraft;
    }

    public void setPilotAircraft(PilotAircraft pilotAircraft) {
        this.pilotAircraft = pilotAircraft;
    }
}
