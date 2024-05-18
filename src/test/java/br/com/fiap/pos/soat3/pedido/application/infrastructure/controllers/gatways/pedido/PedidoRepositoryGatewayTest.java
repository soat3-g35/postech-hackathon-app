package br.com.fiap.pos.soat3.pedido.application.infrastructure.controllers.gatways.pedido;

import br.com.fiap.pos.soat3.pedido.domain.entity.*;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido.PedidoResponse;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.pedido.PedidoEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.pedido.PedidoRepositoryGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.produto.ProdutoRepositoryGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.itempedido.ItemPedidoRepository;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.pedido.PedidoEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.pedido.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoRepositoryGatewayTest {

    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private ProdutoRepositoryGateway produtoRepositoryGateway;
    @Mock
    private ItemPedidoRepository itemPedidoRepository;
    @Mock
    private PedidoEntityMapper pedidoEntityMapper;

    @InjectMocks
    PedidoRepositoryGateway pedidoRepositoryGateway;

    @Test
    public void givenPedidoRepositoryGateway_testlistaPedidos() {
        List<Pedido> pedidos = Collections.emptyList();
        List<PedidoEntity> pedidosEntity = Collections.emptyList();

        when(pedidoRepository.findByStatusNot(StatusPedido.FINALIZADO.name())).thenReturn(pedidosEntity);

        var returnPedidos = pedidoRepositoryGateway.listaPedidos();

        // Assert
        assertEquals("", returnPedidos, pedidos);
    }

    @Test
    public void givenPedidoRepositoryGateway_testlistaPedidosProducao() {
        List<Pedido> pedidos = Collections.emptyList();
        List<PedidoEntity> pedidosEntity = Collections.emptyList();

        var returnPedidos = pedidoRepositoryGateway.listaPedidosProducao();

        // Assert
        assertEquals("", returnPedidos, pedidos);
    }

    @Test
    public void givenPedidoRepositoryGateway_testconsultaStatusPedido() {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setStatus("PRODUCAO");
        when(pedidoRepository.existsById(1L)).thenReturn(true);
        when(pedidoRepository.getReferenceById(1L)).thenReturn(pedidoEntity);

        var returnStatusPedido = pedidoRepositoryGateway.consultaStatusPedido(1L);

        // Assert
        assertEquals("", returnStatusPedido, "PRODUCAO");
    }

    @Test
    public void givenPedidoRepositoryGateway_testalizaStatusPedido() {
        Pedido pedido = new Pedido(1L, Collections.emptyList());
        pedido.setStatus(StatusPedido.PRONTO);
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setStatus("GERADO");
        when(pedidoRepository.existsById(1L)).thenReturn(true);
        when(pedidoRepository.getReferenceById(1L)).thenReturn(pedidoEntity);
        when(pedidoEntityMapper.toDomain(pedidoEntity)).thenReturn(pedido);

        var returnPedido = pedidoRepositoryGateway.atualizaStatusPedido(1L, "PRONTO");

        // Assert
        assertEquals("", StatusPedido.PRONTO, returnPedido.getStatus());
    }

//    @Test
//    public void givenPedidoRepositoryGateway_testgetTotal() {
//
//        Produto produto1 = new Produto(1L);
//        produto1.setValor(new BigDecimal(10));
//        Produto produto2 = new Produto(2L);
//        produto2.setValor( new BigDecimal(20));
//        ItemPedido item1 = new ItemPedido(produto1, 1);
//        ItemPedido item2 = new ItemPedido(produto2, 2);
//
//        List<ItemPedido> intens = Arrays.asList(item1, item2);
//
//
//        //Assert
//        assertEquals("", StatusPedido.PRONTO, returnPedido.getStatus());
//    }


}

