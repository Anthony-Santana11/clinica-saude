package com.example.demo.modules.paciente.repository;

import com.example.demo.modules.paciente.model.FichaPacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FichaPacienteRepository extends JpaRepository<FichaPacienteModel, Integer> {
    Optional<FichaPacienteModel> findById(Integer id);
    List<FichaPacienteModel> findAll();
    List<FichaPacienteModel> findByNomeContainingIgnoreCase(String nome);

}
