package com.example.demo.modules.usuario.controller;

import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.usuario.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class GetUsuarioController {

    private final UsuarioRepository usuarioRepository;

    public GetUsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<?>> getAllUsuarios() {
        try {
            var usuarios = usuarioRepository.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Collections.singletonList(e.getMessage()));
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Integer id) {
            try {
                var usuario = usuarioRepository.findById(id);
                if (usuario.isPresent()) {
                    return ResponseEntity.ok(usuario.get());
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

    @GetMapping("/usuarios/nome/{nome}")
    public ResponseEntity<?> getUsuariosByNome(@PathVariable String nome) {
        try {
            var usuarios = usuarioRepository.findByNomeContainingIgnoreCase(nome);
            return ResponseEntity.ok(usuarios);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/usuarios/clinica/{clinicaId}")
    public ResponseEntity<?> getUsuariosByClinica(@PathVariable Integer clinicaId) {
        try {
            var usuarios = usuarioRepository.findByClinica_Id(clinicaId);
            return ResponseEntity.ok(usuarios);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
