package br.com.fiap.pos.soat3.pedido.application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;

public class CadastraPedidoInteractor {
    private final PedidoGateway pedidoGateway;

    public CadastraPedidoInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido cadastraPedido(Pedido pedido) {
        return pedidoGateway.cadastraPedido(pedido);
    }

}
