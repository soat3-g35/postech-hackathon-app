package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente;

public record ClienteResponse(Long id, String nome, String email, String CPF) {
}
