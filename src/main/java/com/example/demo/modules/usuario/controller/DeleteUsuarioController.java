package com.example.demo.modules.usuario.controller;

import com.example.demo.modules.usuario.services.DeleteUsuarioService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUsuarioController {

    private final DeleteUsuarioService deleteUsuarioService;

    public DeleteUsuarioController(DeleteUsuarioService deleteUsuarioService) {
        this.deleteUsuarioService = deleteUsuarioService;
    }


    @DeleteMapping("/auth/delete/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        try {
            deleteUsuarioService.execute(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage() + " Id fornecido nao foi encontrado: " + id);
        }
    }
}
