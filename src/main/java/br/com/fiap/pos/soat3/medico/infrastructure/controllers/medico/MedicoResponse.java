package br.com.fiap.pos.soat3.medico.infrastructure.controllers.medico;

public record  MedicoResponse(Long id, String nome, String crm, String especialidade, String endereco) {
}
