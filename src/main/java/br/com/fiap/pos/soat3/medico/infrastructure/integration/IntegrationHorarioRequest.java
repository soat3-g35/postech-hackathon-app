package br.com.fiap.pos.soat3.medico.infrastructure.integration;

public record IntegrationHorarioRequest(String duracao, String valor, String diaSemana, String horaInicio, String horaFim, Long medicoId) {
}
