package br.com.fiap.pos.soat3.pedido.application.gateways;

import br.com.fiap.pos.soat3.pedido.infrastructure.integration.MVPResponse;

public interface RealizaPagamentoMockGateway {

    MVPResponse realizaPagamentoMVP(Long pedidoId, Long pagamentoId);
}
