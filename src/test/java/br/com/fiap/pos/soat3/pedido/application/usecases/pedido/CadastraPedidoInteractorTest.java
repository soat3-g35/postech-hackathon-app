package br.com.fiap.pos.soat3.pedido.application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CadastraPedidoInteractorTest {

    @Mock
    private PedidoGateway gateway;

    @InjectMocks
    private CadastraPedidoInteractor useCase;

    @Test
    void givenCorrectData_whenCadastraPedido_shouldReturnPedidoModel() {
        Pedido expected = new Pedido(
               1l,
                new ArrayList<ItemPedido>()
        );
        when(gateway.cadastraPedido(
               expected
        )).thenReturn(expected);

        Pedido current = useCase.cadastraPedido(
               expected
        );

        assertEquals(expected, current);
    }
}
