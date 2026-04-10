package com.example.demo.modules.clinica.controller;

import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.clinica.repository.ClinicaRepository;
import com.example.demo.modules.usuario.model.UsuarioModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetClinicaControllers {

    private final ClinicaRepository clinicaRepository;

    public GetClinicaControllers(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    @GetMapping("/clinica")
    public ResponseEntity<?> getClinica() {
        try {
            return ResponseEntity.ok(clinicaRepository.findAll());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/clinica/{id}")
    public ResponseEntity<?> getClinicaById(@PathVariable Integer id) {
        try {
            ClinicaModel clinica = clinicaRepository.findById(id).orElseThrow(()
                    -> new RuntimeException("Clinica não encontrada"));
            return ResponseEntity.ok(clinica);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/clinica/nome/{nome}")
    public ResponseEntity<?> getClinicaByNome(@PathVariable String nome) {
        try {
            ClinicaModel clinica = clinicaRepository.findByNome(nome).orElseThrow(
                    () -> new RuntimeException("Clinica não encontrada"));
            return ResponseEntity.ok(clinica);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
