package com.example.demo.modules.usuario.dto;

import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.usuario.utils.roles.RoleEnum;

public record UserRequestDTO(String nome, String login, String senha, String funcao, String especialidade, RoleEnum role,  ClinicaModel clinica) {
}
