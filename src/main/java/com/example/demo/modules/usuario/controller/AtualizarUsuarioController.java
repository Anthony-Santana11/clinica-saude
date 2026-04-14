package com.example.demo.modules.usuario.controller;

import com.example.demo.modules.usuario.dto.UserRequestDTO;
import com.example.demo.modules.usuario.services.UpdateUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtualizarUsuarioController {

    private final UpdateUsuarioService updateUsuarioService;

    public AtualizarUsuarioController(UpdateUsuarioService updateUsuarioService) {
        this.updateUsuarioService = updateUsuarioService;
     }


     @PutMapping("/auth/update/{id}")
    public ResponseEntity<?> execute(@PathVariable Integer id, @RequestBody UserRequestDTO request) {
            try {
                var response = updateUsuarioService.execute(request, id);
                return ResponseEntity.ok(response);
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }

}
