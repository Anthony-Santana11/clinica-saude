package com.example.demo.modules.clinica.services;

import com.example.demo.modules.clinica.mapper.ClinicaMapper;
import com.example.demo.modules.clinica.dto.ClinicaRequestDTO;
import com.example.demo.modules.clinica.dto.ClinicaResponseDTO;
import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.clinica.repository.ClinicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateClinicaService {

    private final ClinicaRepository clinicaRepository;
    private final ClinicaMapper clinicaMapper;


    public CreateClinicaService(ClinicaRepository clinicaRepository, ClinicaMapper clinicaMapper) {
        this.clinicaRepository = clinicaRepository;
        this.clinicaMapper = clinicaMapper;
    }

    @Transactional
    public ClinicaResponseDTO executes (ClinicaRequestDTO request) {
        if (clinicaRepository.findByNome(request.nome()).isPresent()) {
            throw new RuntimeException("Clinica já existe");
        }

        ClinicaModel model = clinicaMapper.toModel(request);
        ClinicaModel savedModel = clinicaRepository.save(model);
        return clinicaMapper.toResponseDTO(savedModel);
    }

}
