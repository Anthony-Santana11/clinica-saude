package com.example.demo.modules.usuario.mapper;

import com.example.demo.modules.usuario.dto.AuthResponseDTO;
import com.example.demo.modules.usuario.dto.UserRequestDTO;
import com.example.demo.modules.usuario.dto.UserResponseDTO;
import com.example.demo.modules.usuario.model.UsuarioModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    private final PasswordEncoder passwordEncoder;

    public UsuarioMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioModel toModel(UserRequestDTO request) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(request.nome());
        usuario.setLogin(request.login());
        usuario.setSenha(passwordEncoder.encode(request.senha()));
        usuario.setFuncao(request.funcao());
        usuario.setEspecialidade(request.especialidade());
        usuario.setRole(request.role());
        usuario.setClinica(request.clinica());
        return usuario;
    }

    public UsuarioModel updateModel(UsuarioModel model, UserRequestDTO request) {
        if (request.nome() != null && !request.nome().isBlank())
            model.setNome(request.nome());

        if (request.login() != null && !request.login().isBlank())
            model.setLogin(request.login());

        if (request.senha() != null && !request.senha().isBlank())
            model.setSenha(passwordEncoder.encode(request.senha()));

        if (request.funcao() != null && !request.funcao().isBlank())
            model.setFuncao(request.funcao());

        if (request.especialidade() != null && !request.especialidade().isBlank())
            model.setEspecialidade(request.especialidade());

        if (request.role() != null)
            model.setRole(request.role());

        if (request.clinica() != null && request.clinica().getId() != null)
            model.setClinica(request.clinica());

        return model;
    }

        public UserResponseDTO toResponseDTO(UsuarioModel model) {
            return new UserResponseDTO(
                    model.getId(),
                    model.getNome(),
                    model.getLogin(),
                    model.getSenha(),
                    model.getFuncao(),
                    model.getEspecialidade(),
                    model.getRole(),
                    model.getClinica()
            );
        }

        public AuthResponseDTO toAuthResponseDTO(UsuarioModel model, String token) {
            return new AuthResponseDTO(token, toResponseDTO(model));
        }
}
