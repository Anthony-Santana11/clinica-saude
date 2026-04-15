package com.example.demo.modules.paciente.services;

import com.example.demo.modules.paciente.dto.FichaPacienteRequestDTO;
import com.example.demo.modules.paciente.dto.FichaPacienteResponseDTO;
import com.example.demo.modules.paciente.mapper.FichaPacienteMapper;
import com.example.demo.modules.paciente.model.FichaPacienteModel;
import com.example.demo.modules.paciente.repository.FichaPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateFichaPacienteService {

    private final FichaPacienteRepository fichaPacienteRepository;
    private final FichaPacienteMapper fichaPacienteMapper;

    public CreateFichaPacienteService(FichaPacienteRepository fichaPacienteRepository, FichaPacienteMapper fichaPacienteMapper) {
        this.fichaPacienteRepository = fichaPacienteRepository;
        this.fichaPacienteMapper = fichaPacienteMapper;
    }

    @Transactional
    public FichaPacienteResponseDTO createFichaPaciente(FichaPacienteRequestDTO requestDTO) {
       if (fichaPacienteRepository.findByNomeContainingIgnoreCase(requestDTO.nome()).stream().anyMatch(f -> f.getNome().equalsIgnoreCase(requestDTO.nome()))) {
            throw new RuntimeException("Ficha do paciente já existe");
        }

        FichaPacienteModel model = fichaPacienteMapper.toModel(requestDTO);
        FichaPacienteModel savedModel = fichaPacienteRepository.save(model);
        return fichaPacienteMapper.toResponseDTO(savedModel);

    }

}
