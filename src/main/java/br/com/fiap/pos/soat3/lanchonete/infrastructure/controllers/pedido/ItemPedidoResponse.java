package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;

public record ItemPedidoResponse(Produto produto, int quantidade) {
}
