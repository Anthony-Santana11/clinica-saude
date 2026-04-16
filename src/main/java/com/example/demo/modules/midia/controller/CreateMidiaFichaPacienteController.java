package com.example.demo.modules.midia.controller;

import com.example.demo.modules.midia.dto.MidiaFichaPacienteRequestDTO;
import com.example.demo.modules.midia.service.CreateMidiaFichaPacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateMidiaFichaPacienteController {

    private final CreateMidiaFichaPacienteService createMidiaFichaPacienteService;

    public CreateMidiaFichaPacienteController(CreateMidiaFichaPacienteService createMidiaFichaPacienteService) {
        this.createMidiaFichaPacienteService = createMidiaFichaPacienteService;
    }

    @PostMapping("/auth/midias-ficha-paciente")
    public ResponseEntity<?> createMidiaFichaPaciente(@RequestBody MidiaFichaPacienteRequestDTO requestDTO) {
        try {
            var responseDTO = createMidiaFichaPacienteService.create(requestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
