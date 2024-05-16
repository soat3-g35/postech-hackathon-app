package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;

public record ItemPedidoResponse(Produto produto, int quantidade) {
}
