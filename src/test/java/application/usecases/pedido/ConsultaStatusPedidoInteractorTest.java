package application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultaStatusPedidoInteractorTest {

    @Mock
    private PedidoGateway gateway;

    @InjectMocks
    private ConsultaStatusPedidoInteractor useCase;

    @Test
    void givenCorrectData_whenBuscaStatusPedido_shouldReturnCorrectStatus() {
        when(gateway.consultaStatusPedido(
                1L
        )).thenReturn("GERADO");

        String current = useCase.consultaStatusPedido(
                1L
        );

        assertEquals("GERADO", current);
    }

    @Test
    void givenInvalidData_whenBuscaStatusPedido_shouldReturnNotFound() {
        when(gateway.consultaStatusPedido(
                1L
        )).thenThrow(new Error("NOT FOUND"));


        assertThrows(Error.class, () -> {
            useCase.consultaStatusPedido(
                    1L
            );
        });
    }
}
