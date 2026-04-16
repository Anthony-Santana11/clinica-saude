package com.example.demo.modules.midia.service;

import com.example.demo.modules.midia.dto.MidiaFichaPacienteRequestDTO;
import com.example.demo.modules.midia.dto.MidiaFichaPacienteResponseDTO;
import com.example.demo.modules.midia.mapper.MidiaFichaPacienteMapper;
import com.example.demo.modules.midia.repository.MidiaFichaPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UpdateMidiaFichaPacienteService {

    private final MidiaFichaPacienteRepository repository;
    private final MidiaFichaPacienteMapper mapper;

    public UpdateMidiaFichaPacienteService(MidiaFichaPacienteRepository repository, MidiaFichaPacienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public MidiaFichaPacienteResponseDTO update(Integer id, MidiaFichaPacienteRequestDTO request) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        var existingModel = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("MidiaFichaPaciente com ID " + id + " não encontrado"));

        var updatedModel = mapper.updateModel(existingModel, request);
        var savedModel = repository.save(updatedModel);
        return mapper.toResponseDTO(savedModel);
    }
}
