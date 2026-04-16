package com.example.demo.modules.midia.service;

import com.example.demo.modules.midia.mapper.MidiaFichaPacienteMapper;
import com.example.demo.modules.midia.repository.MidiaFichaPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DeleteMidiaFichaPacienteService {

    private final MidiaFichaPacienteRepository repository;
    private final MidiaFichaPacienteMapper mapper;

    public DeleteMidiaFichaPacienteService(MidiaFichaPacienteRepository repository, MidiaFichaPacienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        var existingModel = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("MidiaFichaPaciente com ID " + id + " não encontrado"));

        repository.delete(existingModel);
    }
}
