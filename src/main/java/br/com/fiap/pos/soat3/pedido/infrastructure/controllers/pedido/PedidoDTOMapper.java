package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.pedido.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTOMapper {

    public List<ItemPedido> toItemPedido(List<ItemPedidoRequest> request) {

        List<ItemPedido> itensPedido = request.stream().
                map(item -> new ItemPedido(new Produto(item.produtoId()), item.quantidade())).toList();

        return itensPedido;
    }

    public PedidoResponse toPedidoResponse(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getClienteId(),
                pedido.getItensPedido().stream().map(item ->
                        new ItemPedidoResponse(
                                item.getProduto(),
                                item.getQuantidade()
                        )
                ).toList(),
                pedido.getTotalPedido(), pedido.getStatus());
    }

    public List<PedidoResponse> toPedidoResponseList(List<Pedido> pedidos) {
        var lista = new ArrayList<PedidoResponse>();

        pedidos.forEach(pedido ->
                lista.add(
                        new PedidoResponse(
                                pedido.getId(),
                                pedido.getClienteId(),
                                pedido.getItensPedido().stream().map(item ->
                                        new ItemPedidoResponse(
                                                item.getProduto(),
                                                item.getQuantidade()
                                        )
                                ).toList(),
                                pedido.getTotalPedido(),
                                pedido.getStatus()
                        )
                )
        );

        return lista;
    }

    public StatusPedidoResponse toStatusPedidoResponse(String status) {
        return new StatusPedidoResponse(status);
    }

    public Pedido toPedido(PedidoRequest request) {
        List<ItemPedido> itensPedido = toItemPedido(request.itensPedido());
        return new Pedido(
                        request.clienteId(),
                        itensPedido
        );
    }
}
