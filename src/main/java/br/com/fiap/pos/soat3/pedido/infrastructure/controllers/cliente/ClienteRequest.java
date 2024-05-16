package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente;

public record ClienteRequest(Long id, String nome, String email, String CPF) {
}
