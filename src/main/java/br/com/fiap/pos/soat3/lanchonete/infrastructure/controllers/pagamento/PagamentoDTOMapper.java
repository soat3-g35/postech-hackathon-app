package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pedido;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido.PedidoDTOMapper;

import java.util.List;

public class PagamentoDTOMapper {
    public Pagamento toPagamento(PagamentoRequest request) {
        PedidoDTOMapper pedidoDTOMapper = new PedidoDTOMapper();
        List<ItemPedido> itensPedido = pedidoDTOMapper.toItemPedido(request.itensPedido());
        return new Pagamento(
                new Pedido(
                        request.clienteId(),
                        itensPedido
                )
        );
    }

    RealizaPagamentoResponse toResponse(Pagamento pagamento) {
        return new RealizaPagamentoResponse(
                pagamento.getId(),
                pagamento.getPedido().getId(),
                pagamento.getPedido().getTotalPedido(),
                pagamento.getQrCode());
    }
}
