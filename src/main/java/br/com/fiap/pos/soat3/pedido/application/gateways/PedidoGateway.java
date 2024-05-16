package br.com.fiap.pos.soat3.pedido.application.gateways;

import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;

import java.util.List;

public interface PedidoGateway {
    Pedido cadastraPedido(Pedido pedido);

    List<Pedido> listaPedidos();

    String consultaStatusPedido(Long pedidoId);

    Pedido atualizaStatusPedido(Long pedidoId, String statusPedido);

}
