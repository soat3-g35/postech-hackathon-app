package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

public record RealizaPagamentoResponse(
        Long id,
        Long pedidoId,
        String totalPedido,
        String qrCode
) {
}
