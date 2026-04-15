package com.example.demo.modules.paciente.controllers;

import com.example.demo.modules.paciente.dto.FichaPacienteRequestDTO;
import com.example.demo.modules.paciente.repository.FichaPacienteRepository;
import com.example.demo.modules.paciente.services.UpdateFichaPacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateFichaPacienteController {

    private final UpdateFichaPacienteService updateFichaPacienteService;
    private final FichaPacienteRepository fichaPacienteRepository;

    public UpdateFichaPacienteController(UpdateFichaPacienteService updateFichaPacienteService, FichaPacienteRepository fichaPacienteRepository) {
        this.updateFichaPacienteService = updateFichaPacienteService;
        this.fichaPacienteRepository = fichaPacienteRepository;
    }

    @PutMapping("/auth/fichas-paciente/{id}")
    public ResponseEntity<?> updateFichaPaciente(@PathVariable Integer id, @RequestBody FichaPacienteRequestDTO requestDTO) {
        try {
            var responseDTO = updateFichaPacienteService.updateFichaPaciente(id, requestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
