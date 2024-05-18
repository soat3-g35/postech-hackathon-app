package br.com.fiap.pos.soat3.pedido.application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaPedidosProducaoInteractor {
    private final PedidoGateway pedidoGateway;

    public ListaPedidosProducaoInteractor(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public List<Pedido> listaPedidosProducao() {
        List<Pedido> list = this.pedidoGateway.listaPedidosProducao();
        if (list != null) {
            return orderList(list);
        } else {
            return new ArrayList<>();
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
