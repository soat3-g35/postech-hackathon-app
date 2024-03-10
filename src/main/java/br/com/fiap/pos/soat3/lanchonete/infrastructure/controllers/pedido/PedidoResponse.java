package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.StatusPedido;

import java.util.List;

public class PedidoResponse {

    private Long id;

    private Long clienteId;

    private List<ItemPedidoResponse> itensPedido;

    private String totalPedido;

    private StatusPedido status;

    public PedidoResponse(
            Long id, Long clienteId,
            List<ItemPedidoResponse> itensPedido,
            String totalPedido,
            StatusPedido status) {
        this.id = id;
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
        this.totalPedido = totalPedido;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedidoResponse> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoResponse> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public String getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(String totalPedido) {
        this.totalPedido = totalPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
