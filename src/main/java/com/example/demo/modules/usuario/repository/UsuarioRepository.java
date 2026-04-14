package com.example.demo.modules.usuario.repository;

import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.usuario.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    List<UsuarioModel> findAll();

    Optional<UsuarioModel> findById(Integer id);

    List<UsuarioModel> findByClinica_Id(Integer clinicaId);

    List<UsuarioModel> findByNomeContainingIgnoreCase(String nome);

    Optional<UsuarioModel> findByLogin(String login);

}
