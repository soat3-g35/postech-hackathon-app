package br.com.fiap.pos.soat3.pedido.application.infrastructure.controllers.pedido;


import br.com.fiap.pos.soat3.pedido.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import br.com.fiap.pos.soat3.pedido.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoDTOMapperTest {

    @InjectMocks
    PedidoDTOMapper mapper;

    @Test
    void toItemPedido_shouldReturnListItemPedido() {
        List<ItemPedidoRequest> list = new ArrayList<>();
        list.add(
                new ItemPedidoRequest(
                        1L,
                        2
                )
        );

        List<ItemPedido> expected = new ArrayList<>();
        expected.add(
                new ItemPedido(
                        new Produto(),
                        2
                )
        );

        List<ItemPedido> current = mapper.toItemPedido(list);

        assertEquals("", expected.size(), current.size());
    }

    @Test
    void toPedidoResponse_shouldReturnPedidoRequest() {
        PedidoRequest expected = new PedidoRequest(
                1l,
                Collections.emptyList()
        );

        Pedido value = new Pedido(
                1l,
                Collections.emptyList()
        );

        PedidoResponse current = mapper.toPedidoResponse(value);

        assertEquals("", expected.clienteId(), current.getClienteId());
    }

    @Test
    void toPedidoResponseList_shouldReturnListPedidoResponse() {
        List<PedidoResponse> list = new ArrayList<>();
        PedidoResponse expected = new PedidoResponse(
                1l,
                2l,
                Collections.emptyList(),
                "20",
                StatusPedido.PREPARACAO
        );
        list.add(expected);

        List<Pedido> pedidos = new ArrayList<>();
        Pedido value = new Pedido(
                1l,
                Collections.emptyList()
        );
        pedidos.add(value);

        List<PedidoResponse> current = mapper.toPedidoResponseList(pedidos);

        assertEquals("", list.size(), current.size());
        assertEquals("", list.get(0).getClienteId(), current.get(0).getClienteId());
    }

    @Test
    void toStatusPedidoResponse_shouldReturnStatusPedidoResponse() {
        StatusPedidoResponse expected = new StatusPedidoResponse(
                "Cancelado"
        );
        StatusPedidoResponse current = mapper.toStatusPedidoResponse("Cancelado");

        assertEquals("", expected.getStatus(), current.getStatus());
    }
}
