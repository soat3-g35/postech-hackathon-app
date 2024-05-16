package br.com.fiap.pos.soat3.pedido.infrastructure.integration;

import br.com.fiap.pos.soat3.pedido.application.gateways.EnviaConfirmacaoGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pagamento.ConfirmacaoResponse;

public class EnviaConfirmacaoMock implements EnviaConfirmacaoGateway {

    private final MVPCliente mVPCliente;

    public EnviaConfirmacaoMock(MVPCliente mVPCliente) {
        this.mVPCliente = mVPCliente;
    }

    @Override
    public ConfirmacaoResponse enviaConfirmacaoMVP(Long pagamentoId) {
        return mVPCliente.verificaPagamentoMock(pagamentoId).getBody();
    }
}
