package com.example.demo.modules.usuario.services;

import com.example.demo.modules.usuario.dto.AuthResponseDTO;
import com.example.demo.modules.usuario.dto.UserRequestDTO;
import com.example.demo.modules.usuario.dto.UserResponseDTO;
import com.example.demo.modules.usuario.mapper.UsuarioMapper;
import com.example.demo.modules.usuario.model.UsuarioModel;
import com.example.demo.modules.usuario.repository.UsuarioRepository;
import com.example.demo.modules.usuario.utils.auth.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public CreateUsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    @Transactional
    public AuthResponseDTO execute(UserRequestDTO request) {
        if (usuarioRepository.findByLogin(request.login()).isPresent()) {
            throw new RuntimeException("Usuário já existe");
        }

        UsuarioModel model = usuarioMapper.toModel(request);
        UsuarioModel savedModel = usuarioRepository.save(model);
        String token = jwtService.generateToken(savedModel);
        return usuarioMapper.toAuthResponseDTO(savedModel, token);
    }
}
