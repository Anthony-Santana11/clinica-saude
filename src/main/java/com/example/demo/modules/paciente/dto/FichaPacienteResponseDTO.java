package com.example.demo.modules.paciente.dto;

import java.util.Date;

public record FichaPacienteResponseDTO(Integer id, String nome, Date dataNascimento, String sexo, String cep, String endereco, String numComplemento, String cidade, String estado, String ocupacao, String bairro, String diagnosticoClinico, String medicacao, String queixaPrincipal, String hpoHma, String exameFisico, String examesComplementares, String conduta, String diagnostico) {
}
