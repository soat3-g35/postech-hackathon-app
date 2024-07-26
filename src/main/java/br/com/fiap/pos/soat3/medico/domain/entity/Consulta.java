package br.com.fiap.pos.soat3.medico.domain.entity;

public class Consulta {

    private Long id;
    private String dataConsulta;
    private String linkConsulta;
    private String justificativaCancelamento;
    private boolean confirmadaMedico;
    private boolean canceladaPaciente;
    private Medico medico;
    private Paciente paciente;

    public Consulta(String dataConsulta, Medico medico, Paciente paciente) {
        this.dataConsulta = dataConsulta;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Consulta(String dataConsulta, String linkConsulta, String justificativaCancelamento, boolean confirmadaMedico, boolean canceladaPaciente, Medico medico, Paciente paciente) {
        this.dataConsulta = dataConsulta;
        this.linkConsulta = linkConsulta;
        this.justificativaCancelamento = justificativaCancelamento;
        this.confirmadaMedico = confirmadaMedico;
        this.canceladaPaciente = canceladaPaciente;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Consulta(Long id, String dataConsulta, String linkConsulta, String justificativaCancelamento, boolean confirmadaMedico, boolean canceladaPaciente, Medico medico, Paciente paciente) {
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
