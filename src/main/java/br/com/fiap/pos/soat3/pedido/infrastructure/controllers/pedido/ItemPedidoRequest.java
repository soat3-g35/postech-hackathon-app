package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido;

public record ItemPedidoRequest(Long produtoId, int quantidade) {
}
