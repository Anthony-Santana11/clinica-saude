package com.example.demo.modules.midia.mapper;

import com.example.demo.modules.midia.dto.MidiaFichaPacienteRequestDTO;
import com.example.demo.modules.midia.dto.MidiaFichaPacienteResponseDTO;
import com.example.demo.modules.midia.model.MidiaFichaPaciente;
import org.springframework.stereotype.Component;

@Component
public class MidiaFichaPacienteMapper {

    public MidiaFichaPaciente toModel(MidiaFichaPacienteRequestDTO request) {
        MidiaFichaPaciente model = new MidiaFichaPaciente();
        model.setDescricao(request.descricao());
        model.setLinkMidia(request.linkMidia());
        model.setFichaPaciente(request.fichaPaciente());
        return model;
    }
    public MidiaFichaPaciente updateModel(MidiaFichaPaciente model, MidiaFichaPacienteRequestDTO request) {
        if (request.descricao() != null) {
            model.setDescricao(request.descricao());
        }
        if (request.linkMidia() != null) {
            model.setLinkMidia(request.linkMidia());
        }
        if (request.fichaPaciente() != null) {
            model.setFichaPaciente(request.fichaPaciente());
        }
        return model;
    }

    public MidiaFichaPacienteResponseDTO toResponseDTO(MidiaFichaPaciente model) {;
        return new MidiaFichaPacienteResponseDTO(
                model.getId(),
                model.getDescricao(),
                model.getLinkMidia(),
                model.getFichaPaciente()
        );
    }
}
