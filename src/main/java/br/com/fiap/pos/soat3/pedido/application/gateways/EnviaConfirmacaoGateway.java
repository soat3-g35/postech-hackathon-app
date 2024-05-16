package br.com.fiap.pos.soat3.pedido.application.gateways;

import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pagamento.ConfirmacaoResponse;

public interface EnviaConfirmacaoGateway {
    ConfirmacaoResponse enviaConfirmacaoMVP(Long pagamentoId);
}
