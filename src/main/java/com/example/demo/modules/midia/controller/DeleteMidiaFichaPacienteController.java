package com.example.demo.modules.midia.controller;

import com.example.demo.modules.midia.service.DeleteMidiaFichaPacienteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteMidiaFichaPacienteController {

    private final DeleteMidiaFichaPacienteService deleteMidiaPacienteService;

    public DeleteMidiaFichaPacienteController(DeleteMidiaFichaPacienteService deleteMidiaPacienteService) {
        this.deleteMidiaPacienteService = deleteMidiaPacienteService;
    }

    @DeleteMapping("/auth/midias-ficha-paciente/{id}")
    public void deleteMidiaFichaPaciente(@PathVariable Integer id) {
        try {
            deleteMidiaPacienteService.delete(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
