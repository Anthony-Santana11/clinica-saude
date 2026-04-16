package com.example.demo.modules.midia.service;

import com.example.demo.modules.midia.dto.MidiaFichaPacienteRequestDTO;
import com.example.demo.modules.midia.dto.MidiaFichaPacienteResponseDTO;
import com.example.demo.modules.midia.mapper.MidiaFichaPacienteMapper;
import com.example.demo.modules.midia.repository.MidiaFichaPacienteRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateMidiaFichaPacienteService {

    private final MidiaFichaPacienteRepository repository;
    private final MidiaFichaPacienteMapper mapper;

    public CreateMidiaFichaPacienteService(MidiaFichaPacienteRepository repository, MidiaFichaPacienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public MidiaFichaPacienteResponseDTO create(MidiaFichaPacienteRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Request não pode ser nulo");
        }

        var model = mapper.toModel(request);
        var savedModel = repository.save(model);
        return mapper.toResponseDTO(savedModel);
    }
}
