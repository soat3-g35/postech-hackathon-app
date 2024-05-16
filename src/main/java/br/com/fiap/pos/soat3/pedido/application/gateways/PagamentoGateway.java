package br.com.fiap.pos.soat3.pedido.application.gateways;

import br.com.fiap.pos.soat3.pedido.domain.entity.Pagamento;

public interface PagamentoGateway {
    Pagamento realizaPagamento(Pagamento pagamento);
}
