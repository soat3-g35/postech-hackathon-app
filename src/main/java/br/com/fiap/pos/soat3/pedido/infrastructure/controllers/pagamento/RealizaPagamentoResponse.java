package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pagamento;

public record RealizaPagamentoResponse(
        Long id,
        Long pedidoId,
        String totalPedido,
        String qrCode
) {
}
