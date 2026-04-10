package com.example.demo.modules.clinica.repository;

import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.usuario.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicaRepository extends JpaRepository<ClinicaModel, Integer> {

    Optional<ClinicaModel> findById(Integer id);

    Optional<ClinicaModel> findByNome(String nome);

    List<ClinicaModel> findAll();

}