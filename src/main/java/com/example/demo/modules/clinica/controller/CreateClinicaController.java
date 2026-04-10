package com.example.demo.modules.clinica.controller;

import com.example.demo.modules.clinica.dto.ClinicaRequestDTO;
import com.example.demo.modules.clinica.repository.ClinicaRepository;
import com.example.demo.modules.clinica.services.CreateClinicaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateClinicaController {

    private final CreateClinicaService createClinicaService;
    private final ClinicaRepository clinicaRepository;

    public CreateClinicaController(CreateClinicaService createClinicaService, ClinicaRepository clinicaRepository) {
        this.createClinicaService = createClinicaService;
        this.clinicaRepository = clinicaRepository;
     }

     @PostMapping("/clinica")
     public ResponseEntity<?> createClinica(@Valid @RequestBody ClinicaRequestDTO clinicaRequestDTO){
            try {
                return ResponseEntity.ok(createClinicaService.executes(clinicaRequestDTO));
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
     }

}
