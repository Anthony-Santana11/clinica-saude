package com.example.demo.modules.clinica.services;

import com.example.demo.modules.clinica.mapper.ClinicaMapper;
import com.example.demo.modules.clinica.repository.ClinicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DeleteClinicaService {

    private final ClinicaRepository clinicaRepository;
    private final ClinicaMapper clinicaMapper;

    public DeleteClinicaService(ClinicaRepository clinicaRepository, ClinicaMapper clinicaMapper) {
        this.clinicaRepository = clinicaRepository;
        this.clinicaMapper = clinicaMapper;
    }

    @Transactional
    public void executes(Integer id) {
        if (clinicaRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Clinica não encontrada");
        }

        clinicaRepository.deleteById(id);
    }
}
