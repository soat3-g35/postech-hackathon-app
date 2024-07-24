package br.com.fiap.pos.soat3.medico.infrastructure.persistence.horario;

import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "horario")
public class HorarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "duracao")
    private String duracao;

    @Column(name = "valor")
    private String valor;

    @Column(name = "dia_semana")
    private String diaSemana;

    @Column(name = "horar_inicio")
    private String horaInicio;

    @Column(name = "hora_fim")
    private String horaFim;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medidco_id", nullable = false)
    private MedicoEntity medico;

    public HorarioEntity() {
    }

    public HorarioEntity(Long id, String duracao, String valor, String diaSemana, String horaInicio, String horaFim, MedicoEntity medico) {
        this.id = id;
        this.duracao = duracao;
        this.valor = valor;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }
}
