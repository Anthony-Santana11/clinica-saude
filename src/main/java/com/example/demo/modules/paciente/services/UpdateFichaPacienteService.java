package com.example.demo.modules.paciente.services;

import com.example.demo.modules.paciente.dto.FichaPacienteRequestDTO;
import com.example.demo.modules.paciente.dto.FichaPacienteResponseDTO;
import com.example.demo.modules.paciente.mapper.FichaPacienteMapper;
import com.example.demo.modules.paciente.model.FichaPacienteModel;
import com.example.demo.modules.paciente.repository.FichaPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UpdateFichaPacienteService {

    private final FichaPacienteRepository fichaPacienteRepository;
    private final FichaPacienteMapper fichaPacienteMapper;

    public UpdateFichaPacienteService(FichaPacienteRepository fichaPacienteRepository, FichaPacienteMapper fichaPacienteMapper) {
        this.fichaPacienteRepository = fichaPacienteRepository;
        this.fichaPacienteMapper = fichaPacienteMapper;
    }

    @Transactional
    public FichaPacienteResponseDTO updateFichaPaciente(Integer id, FichaPacienteRequestDTO requestDTO) {

        FichaPacienteModel model = fichaPacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ficha do paciente não encontrada"));

        FichaPacienteModel updatedModel = fichaPacienteMapper.updateModel(model, requestDTO);
        FichaPacienteModel savedModel = fichaPacienteRepository.save(updatedModel);
        return fichaPacienteMapper.toResponseDTO(savedModel);
    }

}
