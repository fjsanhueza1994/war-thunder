package com.example.ms_aircrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_aircrafts.models.entity.Aircraft;
import com.example.ms_aircrafts.services.AircraftService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/getAircrafts")
    public ResponseEntity<List<Aircraft>> getAircrafts() {
        try {
            return ResponseEntity.ok(aircraftService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAircraft/{id}")
    public ResponseEntity<Aircraft> getAircraft(@PathVariable Long id) {
        System.out.println("id: " + id);
        try {
            return ResponseEntity.ok(aircraftService.findById(id));
        } catch (Exception e) {
            System.out.println("Error en getAircrafts: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveAircraft")
    public ResponseEntity<String> saveAircraft(@RequestBody Aircraft aircraft) {
        try {
            aircraftService.save(aircraft);
            return ResponseEntity.ok("El avión fue guardado correctamente");
        } catch (Exception e) {
            System.out.println("Error en saveAircraft: " + e.getMessage());
            return new ResponseEntity<>("Error guardando el avión", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAircraft/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
//            Falta validar si el avión existe (Opcional)
            aircraftService.deleteById(id);
            return ResponseEntity.ok("El avión fue eliminado");
        } catch (Exception e) {
            return new ResponseEntity<>("Error eliminando el avión", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
