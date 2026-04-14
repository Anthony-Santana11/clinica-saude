package com.example.demo.modules.usuario.model;

import com.example.demo.modules.clinica.model.ClinicaModel;
import com.example.demo.modules.usuario.utils.roles.RoleEnum;
import jakarta.persistence.*;
import org.springframework.context.annotation.Role;

@Entity
@Table(name = "tbl_usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;
    @Column(name ="nome" ,nullable = false, unique = true)
    private String nome;
    @Column(name = "login", nullable = false, unique = true, length = 80)
    private String login;
    @Column(name = "senha", nullable = false, length = 45)
    private String senha;
    @Column(name = "funcao", nullable = false, unique = false, length = 50)
    private String funcao;
    @Column(name = "especializacao", nullable = false, unique = false, length = 50)
    private String especialidade;

    @Column(name = "role", nullable = false, columnDefinition = "ENUM('dono', 'funcionario')")
    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.funcionario;

    @ManyToOne
    @JoinColumn(name = "id_clinica", nullable = false)
    private ClinicaModel clinica;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public ClinicaModel getClinica() {
        return clinica;
    }

    public void setClinica(ClinicaModel clinica) {
        this.clinica = clinica;
    }
}
