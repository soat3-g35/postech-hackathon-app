package br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario;

public record HorarioResponse(Long id, String duracao, String valor, String diaSemana, String horaInicio, String horaFim, Long medicoId) {
}
