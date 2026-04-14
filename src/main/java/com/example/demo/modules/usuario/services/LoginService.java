package com.example.demo.modules.usuario.services;

import com.example.demo.modules.usuario.dto.AuthResponseDTO;
import com.example.demo.modules.usuario.dto.LoginRequestDTO;
import com.example.demo.modules.usuario.mapper.UsuarioMapper;
import com.example.demo.modules.usuario.repository.UsuarioRepository;
import com.example.demo.modules.usuario.utils.auth.JwtService;
import com.example.demo.modules.usuario.utils.config.SecurityConfig;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UsuarioMapper usuarioMapper;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;

    public LoginService(UsuarioMapper usuarioMapper, JwtService jwtService, UsuarioRepository usuarioRepository, SecurityConfig securityConfig, AuthenticationManager authenticationManager) {
        this.usuarioMapper = usuarioMapper;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public AuthResponseDTO login(LoginRequestDTO request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.login(), request.senha())
            );
        } catch (Exception e) {
            throw new Exception("Usuário ou senha inválidos");
        }

        var user = usuarioRepository.findByLogin(request.login())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String token = jwtService.generateToken(user);
        return usuarioMapper.toAuthResponseDTO(user, token);
    }
}
