package com.example.demo.modules.paciente.controllers;

import com.example.demo.modules.paciente.dto.FichaPacienteRequestDTO;
import com.example.demo.modules.paciente.repository.FichaPacienteRepository;
import com.example.demo.modules.paciente.services.CreateFichaPacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateFichaPacienteController {

    private final CreateFichaPacienteService createFichaPacienteService;
    private final FichaPacienteRepository fichaPacienteRepository;

    public CreateFichaPacienteController(CreateFichaPacienteService createFichaPacienteService, FichaPacienteRepository fichaPacienteRepository) {
        this.createFichaPacienteService = createFichaPacienteService;
        this.fichaPacienteRepository = fichaPacienteRepository;
    }

    @PostMapping("/auth/fichas-paciente")
    public ResponseEntity<?> createFichaPaciente(@RequestBody FichaPacienteRequestDTO requestDTO) {
        try {
            var responseDTO = createFichaPacienteService.createFichaPaciente(requestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
