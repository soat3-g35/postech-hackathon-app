package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PedidoRequest(Long clienteId, @Size(min = 1) @NotNull List<ItemPedidoRequest> itensPedido) {
}
