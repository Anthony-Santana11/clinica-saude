package com.example.demo.modules.midia.dto;

import com.example.demo.modules.paciente.model.FichaPacienteModel;

public record MidiaFichaPacienteRequestDTO (
        String descricao,
        String linkMidia,
        FichaPacienteModel fichaPaciente
) {
}
