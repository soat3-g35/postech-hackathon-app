package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;

public record ItemPedidoResponse(Produto produto, int quantidade) {
}
