package br.com.fiap.pos.soat3.pedido.application.usecases.pagamento;

import br.com.fiap.pos.soat3.pedido.application.gateways.PagamentoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pagamento;

public class RealizaPagamentoInteractor {
    private final PagamentoGateway pagamentoGateway;

    public RealizaPagamentoInteractor(PagamentoGateway pagamentoGateway) {
        this.pagamentoGateway = pagamentoGateway;
    }

    public Pagamento realizaPagamento(Pagamento pagamento) {
        return pagamentoGateway.realizaPagamento(pagamento);
    }
}
