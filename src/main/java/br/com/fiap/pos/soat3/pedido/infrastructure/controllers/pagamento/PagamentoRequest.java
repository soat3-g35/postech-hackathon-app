package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pagamento;

import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido.ItemPedidoRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PagamentoRequest(Long clienteId, @Size(min = 1) @NotNull List<ItemPedidoRequest> itensPedido) {
}
