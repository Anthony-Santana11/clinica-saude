package com.example.demo.modules.paciente.controllers;

import com.example.demo.modules.paciente.repository.FichaPacienteRepository;
import com.example.demo.modules.paciente.services.DeleteFichaPacienteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteFichaPacienteController {

    private final DeleteFichaPacienteService deleteFichaPacienteService;
    private final FichaPacienteRepository fichaPacienteRepository;

    public DeleteFichaPacienteController(DeleteFichaPacienteService deleteFichaPacienteService, FichaPacienteRepository fichaPacienteRepository) {
        this.deleteFichaPacienteService = deleteFichaPacienteService;
        this.fichaPacienteRepository = fichaPacienteRepository;
    }

    @DeleteMapping("/auth/fichas-paciente/{id}")
    public void deleteFichaPaciente(@PathVariable Integer id) {
        try {
            deleteFichaPacienteService.deleteFichaPaciente(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao deletar ficha do paciente: " + e.getMessage());
        }
    }
}
