package com.example.demo.modules.clinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_clinica")
public class ClinicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clinica", nullable = false, unique = true)
    private Integer id;
    @Column(name = "nome", nullable = false, unique = true)
    @NotBlank(message = "O nome da clínica é obrigatório")
    private String nome;
    @Column(name = "telefone", nullable = false, unique = true)
    @NotBlank(message = "O telefone da clínica é obrigatório")
    private String telefone;
    @Column(name = "endereco", nullable = false, unique = false)
    @NotBlank(message = "O endereço da clínica é obrigatório")
    private String endereco;
    @Column(name = "complemento", nullable = false, unique = false)
    private String complemento;
    @Column(name = "numero", nullable = false, unique = false)
    private String numero;
    @Column(name = "cep", nullable = false, unique = false)
    private String cep;
    @Column(name = "link_foto", nullable = false, unique = false, length = 255)
    private String linkLogo;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getlinkLogo() {
        return linkLogo;
    }

    public void setlinkLogo(String linkLogo) {
        this.linkLogo = linkLogo;
    }
}
