package com.example.demo.modules.clinica.controller;

import com.example.demo.modules.clinica.services.DeleteClinicaService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteClinicaController {

    private final DeleteClinicaService deleteClinicaService;

    public DeleteClinicaController(DeleteClinicaService deleteClinicaService) {
        this.deleteClinicaService = deleteClinicaService;
    }

    @DeleteMapping("/clinica/{id}")
    public void deleteClinica(@PathVariable Integer id) {
        try {
            deleteClinicaService.executes(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage() + " Id fornecido nao foi encontrado: " + id);
        }
    }
}
