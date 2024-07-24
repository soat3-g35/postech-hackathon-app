package br.com.fiap.pos.soat3.medico.infrastructure.integration;

public record IntegrationHorarioResponse(Long id, String duracao, String valor, String diaSemana, String horaInicio, String horaFim, Long medicoId) {
}
