package br.com.fiap.pos.soat3.pedido.application.usecases.cliente;

import br.com.fiap.pos.soat3.pedido.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.cliente.BuscaClientePorCPFInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscaClientePorCPFInteractorTest {

    @Mock
    private ClienteGateway gateway;

    @InjectMocks
    private BuscaClientePorCPFInteractor useCase;

    @Test
    void givenCorrectData_whenBuscaClientePorCPF_shouldReturnClienteModel() {
        Cliente expected = new Cliente(
               1l, "teste", "email", "123"
        );
        when(gateway.buscaClientePorCPF("123")).thenReturn(expected);

        Cliente current = useCase.bucaClientePorCPF("123");

        assertEquals(expected, current);
    }
}
