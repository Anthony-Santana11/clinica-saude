package com.example.demo.modules.midia.repository;

import com.example.demo.modules.midia.model.MidiaFichaPaciente;
import com.example.demo.modules.paciente.model.FichaPacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MidiaFichaPacienteRepository extends JpaRepository<MidiaFichaPaciente, Integer> {
    Optional<MidiaFichaPaciente> findById(Integer id);
    List<MidiaFichaPaciente> findAll();
    List<MidiaFichaPaciente> findByFichaPaciente_Id(Integer fichaPacienteId);
}
