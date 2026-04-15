package com.example.demo.modules.paciente.controllers;

import com.example.demo.modules.paciente.repository.FichaPacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetFichaPacienteController {

    private final FichaPacienteRepository fichaPacienteRepository;

    public GetFichaPacienteController(FichaPacienteRepository fichaPacienteRepository) {
        this.fichaPacienteRepository = fichaPacienteRepository;
    }

    @GetMapping("/auth/fichas-paciente")
    public ResponseEntity<?> getAllFichasPaciente() {
        return ResponseEntity.ok(fichaPacienteRepository.findAll());
    }

    @GetMapping("/auth/fichas-paciente/{id}")
    public ResponseEntity<?> getFichaPacienteById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(fichaPacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Ficha do paciente não encontrada")));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/auth/fichas-paciente/search/{nome}")
    public ResponseEntity<?> searchFichasPacienteByNome(@PathVariable String nome) {
        try {
            var fichas = fichaPacienteRepository.findByNomeContainingIgnoreCase(nome);
            if (fichas.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(fichas);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
