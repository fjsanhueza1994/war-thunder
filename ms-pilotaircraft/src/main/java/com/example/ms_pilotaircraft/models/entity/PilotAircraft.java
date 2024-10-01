package com.example.ms_pilotaircraft.models.entity;

import com.example.ms_commons.models.entity.Aircraft;
import com.example.ms_commons.models.entity.Pilot;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "pilot_aircraft")
public class PilotAircraft implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pilot_id", referencedColumnName = "id")
    private Pilot pilot;

    @OneToOne
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    private Aircraft aircraft;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Serial
    private static final long serialVersionUID = 3879455568030860283L;
}
