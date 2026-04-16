package com.example.demo.modules.midia.dto;

import com.example.demo.modules.paciente.model.FichaPacienteModel;

public record MidiaFichaPacienteResponseDTO(Integer id, String descricao, String linkMidia, FichaPacienteModel fichaPaciente) {
}
