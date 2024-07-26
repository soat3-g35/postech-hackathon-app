package br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario;

public record HorarioRequest(String nome, String duracao, String valor, String diaSemana, String horaInicio, String horaFim, Long medicoId) {
}
