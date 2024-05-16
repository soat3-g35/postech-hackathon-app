package br.com.fiap.pos.soat3.pedido.application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;

public class AtualizaStatusPedidoInteractor {
    private final PedidoGateway pedidoGateway;

    public AtualizaStatusPedidoInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido atualizaStatusPedido(Long pedidoId, String status) {
        return pedidoGateway.atualizaStatusPedido(pedidoId, status);
    }

}
