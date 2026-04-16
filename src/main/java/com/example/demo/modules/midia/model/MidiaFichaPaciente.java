package com.example.demo.modules.midia.model;

import com.example.demo.modules.paciente.model.FichaPacienteModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_midia")
public class MidiaFichaPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq")
    private Integer id;
    @Column(name = "descricao", length = 255)
    private String descricao;
    @Column(name = "link_midia", length = 255)
    private String linkMidia;
    @JoinColumn(name = "id_ficha")
    @ManyToOne
    private FichaPacienteModel fichaPaciente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkMidia() {
        return linkMidia;
    }

    public void setLinkMidia(String linkMidia) {
        this.linkMidia = linkMidia;
    }

    public FichaPacienteModel getFichaPaciente() {
        return fichaPaciente;
    }

    public void setFichaPaciente(FichaPacienteModel fichaPaciente) {
        this.fichaPaciente = fichaPaciente;
    }
}
