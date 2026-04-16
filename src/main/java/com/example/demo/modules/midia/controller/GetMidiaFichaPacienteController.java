package com.example.demo.modules.midia.controller;

import com.example.demo.modules.midia.repository.MidiaFichaPacienteRepository;
import com.example.demo.modules.paciente.model.FichaPacienteModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMidiaFichaPacienteController {

    private final MidiaFichaPacienteRepository midiaFichaPacienteRepository;

    public GetMidiaFichaPacienteController(MidiaFichaPacienteRepository midiaFichaPacienteRepository) {
        this.midiaFichaPacienteRepository = midiaFichaPacienteRepository;
    }

    @GetMapping("/auth/midias-ficha-paciente")
    public ResponseEntity<?> getAllMidiasFichaPaciente() {
        try {
            var midias = midiaFichaPacienteRepository.findAll();
            return ResponseEntity.ok(midias);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/auth/midias-ficha-paciente/{id}")
    public ResponseEntity<?> getMidiaFichaPacienteById(@PathVariable  Integer id) {
        try {
            var midia = midiaFichaPacienteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("MidiaFichaPaciente com ID " + id + " não encontrado"));
            return ResponseEntity.ok(midia);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/auth/fichas-paciente/{idFichaPaciente}/midias")
    public ResponseEntity<?> getMidiasByFichaPacienteId(@PathVariable Integer idFichaPaciente) {
        try {
            var midias = midiaFichaPacienteRepository.findByFichaPaciente_Id(idFichaPaciente);
            return ResponseEntity.ok(midias);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
