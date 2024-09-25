package com.example.ms_pilots.controller;

import com.example.ms_pilots.models.entity.Pilot;
import com.example.ms_pilots.services.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilots")
public class PilotController {

    private final PilotService pilotService;

    @Autowired
    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @GetMapping("/getPilots")
    public ResponseEntity<List<Pilot>> getPilots() {
        try {
            return ResponseEntity.ok(pilotService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPilot/{id}")
    public ResponseEntity<Pilot> getPilot(@PathVariable Long id) {
        System.out.println("id: " + id);
        try {
            return ResponseEntity.ok(pilotService.findById(id));
        } catch (Exception e) {
            System.out.println("Error en getPilots: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/savePilot")
    public ResponseEntity<String> savePilot(@RequestBody Pilot pilot) {
        try {
            pilotService.save(pilot);
            return ResponseEntity.ok("El piloto fue guardado correctamente");
        } catch (Exception e) {
            System.out.println("Error en savePilot: " + e.getMessage());
            return new ResponseEntity<>("Error guardando el piloto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePilot/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
//            Falta validar si el piloto existe (Opcional)
            pilotService.deleteById(id);
            return ResponseEntity.ok("El piloto fue eliminado");
        } catch (Exception e) {
            return new ResponseEntity<>("Error eliminando el piloto", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
