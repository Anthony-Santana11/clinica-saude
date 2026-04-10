package com.example.demo.modules.clinica.mapper;

import com.example.demo.modules.clinica.dto.ClinicaRequestDTO;
import com.example.demo.modules.clinica.dto.ClinicaResponseDTO;
import com.example.demo.modules.clinica.model.ClinicaModel;
import org.springframework.stereotype.Component;

@Component
public class ClinicaMapper {

    public ClinicaModel toModel(ClinicaRequestDTO request) {
        ClinicaModel model = new ClinicaModel();
        model.setNome(request.nome());
        model.setTelefone(request.telefone());
        model.setEndereco(request.endereco());
        model.setComplemento(request.complemento());
        model.setNumero(request.numero());
        model.setCep(request.cep());
        model.setlinkLogo(request.linkLogo());
        return model;
    }

    public ClinicaModel updateModel(ClinicaModel model, ClinicaRequestDTO request) {
        model.setNome(request.nome());
        model.setTelefone(request.telefone());
        model.setEndereco(request.endereco());
        model.setComplemento(request.complemento());
        model.setNumero(request.numero());
        model.setCep(request.cep());
        model.setlinkLogo(request.linkLogo());
        return model;
    }

    public ClinicaResponseDTO toResponseDTO(ClinicaModel model) {
        return new ClinicaResponseDTO(
                model.getId(),
                model.getNome(),
                model.getTelefone(),
                model.getEndereco(),
                model.getComplemento(),
                model.getNumero(),
                model.getCep(),
                model.getlinkLogo()
        );
    }
}
