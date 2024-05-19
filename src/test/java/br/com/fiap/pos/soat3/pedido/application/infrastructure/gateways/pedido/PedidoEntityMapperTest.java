package br.com.fiap.pos.soat3.pedido.application.infrastructure.gateways.pedido;

import br.com.fiap.pos.soat3.pedido.domain.entity.*;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.pedido.PedidoEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.cliente.ClienteEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.pedido.PedidoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
@ExtendWith(MockitoExtension.class)
public class PedidoEntityMapperTest {

    @InjectMocks
    PedidoEntityMapper mapper;

    @Test
    void toEntity_shouldReturnPedidoEntity() {

        Produto produto1 = new Produto(1L);
        produto1.setValor(new BigDecimal(10));
        ItemPedido item1 = new ItemPedido(produto1, 1);
        List<ItemPedido> itens = Arrays.asList(item1);
        Pedido pedido = new Pedido(1L, itens);
        pedido.setId(1L);
        pedido.setClienteId(1L);
        pedido.setStatus(StatusPedido.PRONTO);

        var current = mapper.toEntity(pedido);

        assertEquals("", pedido.getStatus().toString(), current.getStatus().toString());
        assertEquals("", pedido.getClienteId(), current.getCliente().getId());

    }

    @Test
    void toDomainObj_shouldReturnPedidoObj() {
        Pedido expected = new Pedido();
        expected.setId(1L);
        expected.setStatus(StatusPedido.PRONTO);
        PedidoEntity model = new PedidoEntity(1L, "PRONTO");
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(1L);
        model.setCliente(clienteEntity);
        model.setItensPedido(Collections.emptyList());

        var current = mapper.toDomain(model);

        assertEquals("", expected.getId(), current.getId());
        assertEquals("", expected.getStatus(), current.getStatus());
    }

}
