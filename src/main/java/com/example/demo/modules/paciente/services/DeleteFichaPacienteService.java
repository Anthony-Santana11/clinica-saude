package com.example.demo.modules.paciente.services;

import com.example.demo.modules.paciente.mapper.FichaPacienteMapper;
import com.example.demo.modules.paciente.repository.FichaPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DeleteFichaPacienteService {

    private final FichaPacienteRepository fichaPacienteRepository;
    private final FichaPacienteMapper fichaPacienteMapper;

    public DeleteFichaPacienteService(FichaPacienteRepository fichaPacienteRepository, FichaPacienteMapper fichaPacienteMapper) {
        this.fichaPacienteRepository = fichaPacienteRepository;
        this.fichaPacienteMapper = fichaPacienteMapper;
    }

    @Transactional
    public void deleteFichaPaciente(Integer id) {
        if (!fichaPacienteRepository.existsById(id)) {
            throw new RuntimeException("Ficha do paciente não encontrada");
        }
        fichaPacienteRepository.deleteById(id);
    }
}
