package com.example.demo.modules.usuario.services;

import com.example.demo.modules.usuario.dto.UserRequestDTO;
import com.example.demo.modules.usuario.dto.UserResponseDTO;
import com.example.demo.modules.usuario.mapper.UsuarioMapper;
import com.example.demo.modules.usuario.model.UsuarioModel;
import com.example.demo.modules.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UpdateUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UpdateUsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Transactional
    public UserResponseDTO execute(UserRequestDTO request, Integer id) {
        UsuarioModel existingUser = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        UsuarioModel updatedUser = usuarioMapper.updateModel(existingUser, request);
        UsuarioModel savedUser = usuarioRepository.save(updatedUser);
        return usuarioMapper.toResponseDTO(savedUser);
    }
}
