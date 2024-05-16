package application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.ListaPedidosInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.pos.soat3.pedido.domain.entity.StatusPedido.RECEBIDO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListaPedidosInteractorTest {

    @Mock
    private PedidoGateway gateway;

    @InjectMocks
    private ListaPedidosInteractor useCase;

    @Test
    public void whenListaPedidos_shouldReturnCorrectList() {
        List<Pedido> expected = new ArrayList<>();
        Pedido pedido = new Pedido(
                1l,
                new ArrayList<>()
        );
        pedido.setStatus(RECEBIDO);
        expected.add(0, pedido);


        when(gateway.listaPedidos()).thenReturn(expected);

        List<Pedido> current = useCase.listaPedidos();

        assertEquals(expected, current);
        assertEquals(1, current.size());
    }

    @Test
    public void whenListaPedidos_shouldReturnEmptyList() {
        when(gateway.listaPedidos()).thenReturn(null);

        List<Pedido> current = useCase.listaPedidos();

        assertNull(current);
    }
}
