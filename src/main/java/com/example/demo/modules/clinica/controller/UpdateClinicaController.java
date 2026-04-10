package com.example.demo.modules.clinica.controller;

import com.example.demo.modules.clinica.dto.ClinicaRequestDTO;
import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.clinica.repository.ClinicaRepository;
import com.example.demo.modules.clinica.services.UpdateClinicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateClinicaController {

    private final UpdateClinicaService updateClinicaService;
    private final ClinicaRepository clinicaRepository;


    public UpdateClinicaController(UpdateClinicaService updateClinicaService, ClinicaRepository clinicaRepository) {
        this.updateClinicaService = updateClinicaService;
        this.clinicaRepository = clinicaRepository;
    }

     @PutMapping("/clinica/{id}")
     public ResponseEntity<?> updateClinica(@PathVariable Integer id, @RequestBody ClinicaRequestDTO request) {
        try {
            return ResponseEntity.ok(updateClinicaService.executes(id, request));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
     }
}
