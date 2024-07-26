package br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "crm")
    private String crm;

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "endereco")
    private String endereco;

    public MedicoEntity() {
    }

    public MedicoEntity(Long id) {
        this.id = id;
    }

    public MedicoEntity(Long id, String nome, String crm, String especialidade, String endereco) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
