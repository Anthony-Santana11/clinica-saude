package com.example.demo.modules.paciente.mapper;

import com.example.demo.modules.paciente.dto.FichaPacienteRequestDTO;
import com.example.demo.modules.paciente.dto.FichaPacienteResponseDTO;
import com.example.demo.modules.paciente.model.FichaPacienteModel;
import org.springframework.stereotype.Component;

@Component
public class FichaPacienteMapper {

    public FichaPacienteModel toModel(FichaPacienteRequestDTO request) {
        FichaPacienteModel model = new FichaPacienteModel();
        model.setNome(request.nome());
        model.setDataNascimento(request.dataNascimento());
        model.setSexo(request.sexo());
        model.setCep(request.cep());
        model.setEndereco(request.endereco());
        model.setNumComplemento(request.numComplemento());
        model.setCidade(request.cidade());
        model.setEstado(request.estado());
        model.setOcupacao(request.ocupacao());
        model.setBairro(request.bairro());
        model.setDiagnosticoClinico(request.diagnosticoClinico());
        model.setMedicacao(request.medicacao());
        model.setQueixaPrincipal(request.queixaPrincipal());
        model.setHpoHma(request.hpoHma());
        model.setExameFisico(request.exameFisico());
        model.setExamesComplementares(request.examesComplementares());
        model.setConduta(request.conduta());
        model.setDiagnostico(request.diagnostico());
        return model;
    }

    public FichaPacienteModel updateModel(FichaPacienteModel model, FichaPacienteRequestDTO request) {
        if (request.nome() != null && !request.nome().isBlank())
            model.setNome(request.nome());

        if (request.dataNascimento() != null)
            model.setDataNascimento(request.dataNascimento());

        if (request.sexo() != null && !request.sexo().isBlank())
            model.setSexo(request.sexo());

        if (request.cep() != null && !request.cep().isBlank())
            model.setCep(request.cep());

        if (request.endereco() != null && !request.endereco().isBlank())
            model.setEndereco(request.endereco());

        if (request.numComplemento() != null && !request.numComplemento().isBlank())
            model.setNumComplemento(request.numComplemento());

        if (request.cidade() != null && !request.cidade().isBlank())
            model.setCidade(request.cidade());

        if (request.estado() != null && !request.estado().isBlank())
            model.setEstado(request.estado());

        if (request.ocupacao() != null && !request.ocupacao().isBlank())
            model.setOcupacao(request.ocupacao());

        if (request.bairro() != null && !request.bairro().isBlank())
            model.setBairro(request.bairro());

        if (request.diagnosticoClinico() != null && !request.diagnosticoClinico().isBlank())
            model.setDiagnosticoClinico(request.diagnosticoClinico());

        if (request.medicacao() != null && !request.medicacao().isBlank())
            model.setMedicacao(request.medicacao());

        if (request.queixaPrincipal() != null && !request.queixaPrincipal().isBlank())
            model.setQueixaPrincipal(request.queixaPrincipal());

        if (request.hpoHma() != null && !request.hpoHma().isBlank())
            model.setHpoHma(request.hpoHma());

        if (request.exameFisico() != null && !request.exameFisico().isBlank())
            model.setExameFisico(request.exameFisico());

        if (request.examesComplementares() != null && !request.examesComplementares().isBlank())
            model.setExamesComplementares(request.examesComplementares());

        if (request.conduta() != null && !request.conduta().isBlank())
            model.setConduta(request.conduta());
        if (request.diagnostico() != null && !request.diagnostico().isBlank())
            model.setDiagnostico(request.diagnostico());
        return model;
    }

    public FichaPacienteResponseDTO toResponseDTO(FichaPacienteModel model) {
        return new FichaPacienteResponseDTO(
                model.getId(),
                model.getNome(),
                model.getDataNascimento(),
                model.getSexo(),
                model.getCep(),
                model.getEndereco(),
                model.getNumComplemento(),
                model.getCidade(),
                model.getEstado(),
                model.getOcupacao(),
                model.getBairro(),
                model.getDiagnosticoClinico(),
                model.getMedicacao(),
                model.getQueixaPrincipal(),
                model.getHpoHma(),
                model.getExameFisico(),
                model.getExamesComplementares(),
                model.getConduta(),
                model.getDiagnostico()
        );
    }

}
