package com.example.demo.modules.paciente.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_fichapaciente")
public class FichaPacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer id;
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;
    @Column(name = "data_nasc", nullable = false)
    private Date dataNascimento;
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;
    @Column(name = "cep", nullable = false, length = 11)
    private String cep;
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;
    @Column(name = "num_complemento", nullable = false, length = 60)
    private String numComplemento;
    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;
    @Column(name = "estado", nullable = false, length = 2)
    private String estado;
    @Column(name = "ocupacao", nullable = false, length = 45)
    private String ocupacao;
    @Column(name = "bairro", nullable = false, length = 45)
    private String bairro;
    @Column(name = "diagnostico_clinico", nullable = false, columnDefinition = "TEXT")
    private String diagnosticoClinico;
    @Column(name = "medicacoes", nullable = false, columnDefinition = "TEXT")
    private String medicacao;
    @Column(name = "queixa_principal", nullable = false, columnDefinition = "TEXT")
    private String queixaPrincipal;
    @Column(name = "hpo_hma", nullable = false, columnDefinition = "TEXT")
    private String hpoHma;
    @Column(name = "exame_fisico", nullable = false, columnDefinition = "TEXT")
    private String exameFisico;
    @Column(name = "exames_comple", nullable = false, columnDefinition = "TEXT")
    private String examesComplementares;
    @Column(name = "conduta_clinica", nullable = false, columnDefinition = "TEXT")
    private String conduta;
    @Column(name = "diagnostico", nullable = false, columnDefinition = "TEXT")
    private String diagnostico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumComplemento() {
        return numComplemento;
    }

    public void setNumComplemento(String numComplemento) {
        this.numComplemento = numComplemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDiagnosticoClinico() {
        return diagnosticoClinico;
    }

    public void setDiagnosticoClinico(String diagnosticoClinico) {
        this.diagnosticoClinico = diagnosticoClinico;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public String getHpoHma() {
        return hpoHma;
    }

    public void setHpoHma(String hpoHma) {
        this.hpoHma = hpoHma;
    }

    public String getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(String exameFisico) {
        this.exameFisico = exameFisico;
    }

    public String getExamesComplementares() {
        return examesComplementares;
    }

    public void setExamesComplementares(String examesComplementares) {
        this.examesComplementares = examesComplementares;
    }

    public String getConduta() {
        return conduta;
    }

    public void setConduta(String conduta) {
        this.conduta = conduta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
