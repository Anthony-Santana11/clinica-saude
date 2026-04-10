package com.example.demo.modules.clinica.services;

import com.example.demo.modules.clinica.mapper.ClinicaMapper;
import com.example.demo.modules.clinica.dto.ClinicaRequestDTO;
import com.example.demo.modules.clinica.dto.ClinicaResponseDTO;
import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.clinica.repository.ClinicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UpdateClinicaService {
    private final ClinicaRepository clinicaRepository;
    private final ClinicaMapper clinicaMapper;

    public UpdateClinicaService(ClinicaRepository clinicaRepository, ClinicaMapper clinicaMapper) {
        this.clinicaRepository = clinicaRepository;
        this.clinicaMapper = clinicaMapper;
    }

    @Transactional
    public ClinicaResponseDTO executes(Integer id, ClinicaRequestDTO request) {

        ClinicaModel model = clinicaRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Clinica não encontrada"));

        clinicaMapper.updateModel(model, request);
        ClinicaModel updatedModel = clinicaRepository.save(model);
        return clinicaMapper.toResponseDTO(updatedModel);

    }
}
