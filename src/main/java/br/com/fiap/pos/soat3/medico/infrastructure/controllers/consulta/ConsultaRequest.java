package br.com.fiap.pos.soat3.medico.infrastructure.controllers.consulta;

public record ConsultaRequest(String dataConsulta, Long medicoId, Long pacienteId) {
}