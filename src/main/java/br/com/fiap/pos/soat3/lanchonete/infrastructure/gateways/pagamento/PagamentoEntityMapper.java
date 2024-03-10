package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Pagamento;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.cliente.ClienteEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pagamento.PagamentoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoEntity;

public class PagamentoEntityMapper {
    PagamentoEntity toEntity(Pagamento pagamentoDomainObj) {

        PedidoEntity pedido = new PedidoEntity();
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(pagamentoDomainObj.getPedido().getClienteId());
        pedido.setId(pagamentoDomainObj.getPedido().getId());
        pedido.setTotalPedido(pagamentoDomainObj.getPedido().getTotalPedido());
        pedido.setCliente(cliente);
        pedido.setStatus(pagamentoDomainObj.getPedido().getStatus().getStatus());

        return new PagamentoEntity(
                pedido,
                pagamentoDomainObj.getQrCode(),
                pagamentoDomainObj.getWebhook());
    }
}
