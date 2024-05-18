package br.com.fiap.pos.soat3.pedido.application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import br.com.fiap.pos.soat3.pedido.domain.entity.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static br.com.fiap.pos.soat3.pedido.domain.entity.StatusPedido.RECEBIDO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListaPedidosProducaoInteractorTest {

    @Mock
    private PedidoGateway pedidoGateway;

    @InjectMocks
    private ListaPedidosProducaoInteractor listaPedidosProducaoInteractor;

    @Test
    void whenListaPedidosProducaoInteractor_listaPedidosProducaoEmpty() {

        List<Pedido> list = Collections.emptyList();
        when(pedidoGateway.listaPedidosProducao()).thenReturn(list);

        List<Pedido> listaPedidos = listaPedidosProducaoInteractor.listaPedidosProducao();

        assertEquals(listaPedidos.size(), 0);
    }

    @Test
    void whenListaPedidosProducaoInteractor_listaPedidosProducaoNull() {

        List<Pedido> list = null;
        when(pedidoGateway.listaPedidosProducao()).thenReturn(list);

        List<Pedido> listaPedidos = listaPedidosProducaoInteractor.listaPedidosProducao();

        assertEquals(listaPedidos.size(), 0);
    }

    @Test
    void whenListaPedidosProducaoInteractor_listaPedidosProducao() {

        Produto produto1 = new Produto(1L);
        produto1.setValor(new BigDecimal(10));
        ItemPedido item1 = new ItemPedido(produto1, 1);

        List<ItemPedido> itens = Arrays.asList(item1);
        Pedido pedido = new Pedido(1L, itens);
        pedido.setStatus(StatusPedido.PRONTO);
        Pedido pedido2 = new Pedido(2L, itens);
        pedido2.setStatus(StatusPedido.PREPARACAO);

        List<Pedido> list = Arrays.asList(pedido, pedido2);
        when(pedidoGateway.listaPedidosProducao()).thenReturn(list);

        List<Pedido> listaPedidos = listaPedidosProducaoInteractor.listaPedidosProducao();

        assertEquals(listaPedidos.size(), 2);
    }
}
