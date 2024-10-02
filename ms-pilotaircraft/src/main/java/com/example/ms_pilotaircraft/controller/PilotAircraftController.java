package com.example.ms_pilotaircraft.controller;

import com.example.ms_commons.models.entity.Aircraft;
import com.example.ms_commons.models.entity.Pilot;
import com.example.ms_pilotaircraft.models.dto.AssignPilotAircraftResponse;
import com.example.ms_pilotaircraft.models.entity.PilotAircraft;
import com.example.ms_pilotaircraft.services.PilotAircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/pilotaircraft")
public class PilotAircraftController {

    private final PilotAircraftService pilotAircraftService;
    private final RestTemplate restTemplate;

    @Value("${pilotaircraft.services.pilots}")
    private String pilotsServiceUrl;

    @Value("${pilotaircraft.services.aircrafts}")
    private String aircraftsServiceUrl;

    @Autowired
    public PilotAircraftController(PilotAircraftService pilotAircraftService,
                                   RestTemplate restTemplate) {
        this.pilotAircraftService = pilotAircraftService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/assign/{idPilot}/{idAircraft}")
    public ResponseEntity<AssignPilotAircraftResponse>  assignPilotToAircraft(@PathVariable Long idPilot, @PathVariable Long idAircraft) {
        // Llama al servicio ms-pilots para verificar si el piloto existe
        String urlGetPilot = pilotsServiceUrl + "/getPilot/" + idPilot;
        System.out.println("URL getPilot: " + urlGetPilot);
        ResponseEntity<Pilot> pilotResponse = restTemplate.getForEntity(urlGetPilot, Pilot.class, idPilot);
        if (!pilotResponse.getStatusCode().is2xxSuccessful() || pilotResponse.getBody() == null) {
            AssignPilotAircraftResponse response = new AssignPilotAircraftResponse("Piloto no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Llama al servicio ms-aircrafts para verificar si el avión existe
        String urlGetAircraft = aircraftsServiceUrl + "/getAircraft/" + idAircraft;
        System.out.println("URL getAircraft: " + urlGetAircraft);
        ResponseEntity<Aircraft> aircraftResponse = restTemplate.getForEntity(urlGetAircraft, Aircraft.class, idAircraft);
        if (!aircraftResponse.getStatusCode().is2xxSuccessful() || aircraftResponse.getBody() == null) {
            AssignPilotAircraftResponse response = new AssignPilotAircraftResponse("Avión no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Pilot pilot = pilotResponse.getBody();
        Aircraft aircraft = aircraftResponse.getBody();

        System.out.println("Pilot{" +
            "id=" + pilot.getId() +
            ", name='" + pilot.getName() + '\'' +
            ", lastname='" + pilot.getLastName() + '\'' +
            ", city='" + pilot.getCity() + '\'' +
            ", country='" + pilot.getCountry() +
            '}');

        System.out.println("Aircraft: " +
            "id=" + aircraft.getId() +
            ", model='" + aircraft.getModel() + '\'' +
            ", lastname='" + aircraft.getRegistration() + '\'' +
            ", manufacturer='" + aircraft.getManufacturer() +
            ", manufacturedYear='" + aircraft.getManufacturedYear() + '\'' +
            '}');

        // Verificamos si el piloto o el avión ya están asignados
        try {
            pilotAircraftService.isPilotOrAircraftAssigned(idPilot, idAircraft);
            // Si no se lanza ninguna excepción, significa que no están asignados, y procedemos con la asignación
            PilotAircraft pilotAircraft = new PilotAircraft();
            pilotAircraft.setPilot(pilot);
            pilotAircraft.setAircraft(aircraft);
            System.out.println("PilotAircraft a guardar: " +
                    "id=" + pilotAircraft.getId() +
                    ", pilot='" + pilotAircraft.getPilot().getId() + '\'' +
                    ", aircraft='" + pilotAircraft.getAircraft().getId() + '\'' +
                    '}');
            System.out.println("{ pilot='" + pilotAircraft.getPilot() + '\'' +
                    ", aircraft='" + pilotAircraft.getAircraft() + "}" );
            PilotAircraft savedAssigment = pilotAircraftService.assignPilotToAircraft(pilotAircraft);

            // Creamos una respuesta con el mensaje y el objeto asignado
            AssignPilotAircraftResponse response = new AssignPilotAircraftResponse(
                    "Asignación exitosa",
                    savedAssigment
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Si se lanza una excepción, devolvemos el mensaje de error con el detalle
            AssignPilotAircraftResponse response = new AssignPilotAircraftResponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @GetMapping("/getPilotAircraft/{id}")
    public ResponseEntity<PilotAircraft> getPilotAircraft(@PathVariable Long id) {
        try {
            return pilotAircraftService.getPilotAircraft(id)
                    .map(ResponseEntity::ok)
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/unassign/{id}")
    public ResponseEntity<Void> unassignPilotFromAircraft(@PathVariable Long id) {
        try {
            pilotAircraftService.unassignPilotFromAircraft(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
