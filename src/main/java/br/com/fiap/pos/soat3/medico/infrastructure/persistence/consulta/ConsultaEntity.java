package br.com.fiap.pos.soat3.medico.infrastructure.persistence.consulta;

import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.paciente.PacienteEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "consulta")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "data_consulta")
    private String dataConsulta;

    @Column(name = "link_consulta")
    private String linkConsulta;

    @Column(name = "justificativa_cancelamento")
    private String justificativaCancelamento;

    @Column(name = "confirmada_medico")
    private boolean confirmadaMedico;

    @Column(name = "cancelada_paciente")
    private boolean canceladaPaciente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medidco_id", nullable = false)
    private MedicoEntity medico;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteEntity paciente;

    public ConsultaEntity() {
    }

    public ConsultaEntity(Long id, String dataConsulta, String linkConsulta, String justificativaCancelamento, boolean confirmadaMedico, boolean canceladaPaciente, MedicoEntity medico, PacienteEntity paciente) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.linkConsulta = linkConsulta;
        this.justificativaCancelamento = justificativaCancelamento;
        this.confirmadaMedico = confirmadaMedico;
        this.canceladaPaciente = canceladaPaciente;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getLinkConsulta() {
        return linkConsulta;
    }

    public void setLinkConsulta(String linkConsulta) {
        this.linkConsulta = linkConsulta;
    }

    public String getJustificativaCancelamento() {
        return justificativaCancelamento;
    }

    public void setJustificativaCancelamento(String justificativaCancelamento) {
        this.justificativaCancelamento = justificativaCancelamento;
    }

    public boolean isConfirmadaMedico() {
        return confirmadaMedico;
    }

    public void setConfirmadaMedico(boolean confirmadaMedico) {
        this.confirmadaMedico = confirmadaMedico;
    }

    public boolean isCanceladaPaciente() {
        return canceladaPaciente;
    }

    public void setCanceladaPaciente(boolean canceladaPaciente) {
        this.canceladaPaciente = canceladaPaciente;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }
}
