package com.example.demo.modules.usuario.controller;

import com.example.demo.modules.usuario.dto.UserRequestDTO;
import com.example.demo.modules.usuario.repository.UsuarioRepository;
import com.example.demo.modules.usuario.services.CreateUsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUsuarioController {

    private final CreateUsuarioService createUsuarioService;
    private final UsuarioRepository usuarioRepository;

    public CreateUsuarioController(CreateUsuarioService createUsuarioService, UsuarioRepository usuarioRepository) {
        this.createUsuarioService = createUsuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/create/user")
    public ResponseEntity<?> execute(@RequestBody @Valid UserRequestDTO request) {
        try {
            var response = createUsuarioService.execute(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
