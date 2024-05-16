package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido.PedidoResponse;

public record PagamentoResponse(Long id, PedidoResponse pedido, String qrCode) {
}
