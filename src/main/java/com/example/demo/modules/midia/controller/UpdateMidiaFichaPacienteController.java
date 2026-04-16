package com.example.demo.modules.midia.controller;

import com.example.demo.modules.midia.dto.MidiaFichaPacienteRequestDTO;
import com.example.demo.modules.midia.service.UpdateMidiaFichaPacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateMidiaFichaPacienteController {

    private final UpdateMidiaFichaPacienteService updateMidiaPacienteService;

    public UpdateMidiaFichaPacienteController(UpdateMidiaFichaPacienteService updateMidiaPacienteService) {
        this.updateMidiaPacienteService = updateMidiaPacienteService;
    }

    @PutMapping("/auth/midias-ficha-paciente/{id}")
    public ResponseEntity<?> updateMidiaFichaPaciente(@PathVariable Integer id, @RequestBody MidiaFichaPacienteRequestDTO requestDTO) {
        try {
            var responseDTO = updateMidiaPacienteService.update( id ,requestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
