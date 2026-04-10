package com.example.demo.modules.clinica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClinicaRequestDTO(String nome, String telefone, String endereco, String complemento, String numero, String cep, String linkLogo) {
}
