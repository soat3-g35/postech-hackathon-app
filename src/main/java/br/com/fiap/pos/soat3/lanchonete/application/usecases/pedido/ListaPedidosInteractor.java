package br.com.fiap.pos.soat3.lanchonete.application.usecases.pedido;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;

import java.util.Comparator;
import java.util.List;

public class ListaPedidosInteractor {
    private final PedidoGateway pedidoGateway;

    public ListaPedidosInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public List<Pedido> listaPedidos() {
        List<Pedido> list = this.pedidoGateway.listaPedidos();
        if (list != null) {
            return orderList(list);
        } else {
            return null;
        }
    }

    private List<Pedido> orderList(List<Pedido> list) {
        Comparator<Pedido> comparadorStatus = Comparator.comparingInt(pedido -> switch (pedido.getStatus()) {
            case PRONTO -> 0;
            case PREPARACAO -> 1;
            case RECEBIDO -> 2;
            default -> 3;
        });

        comparadorStatus = comparadorStatus.thenComparing(Pedido::getDataDeCriacao).reversed();

        list.sort(comparadorStatus);
        return list;
    }
}
