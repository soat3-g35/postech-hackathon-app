package application.usecases.cliente;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.BuscaClientePorCPFInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.CadastraClienteInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CadastraClienteInteractorTest {

    @Mock
    private ClienteGateway gateway;

    @InjectMocks
    private CadastraClienteInteractor useCase;

    @Test
    public void givenCorrectData_whenCadastraCliente_shouldReturnClienteModel() {
        Cliente expected = new Cliente(
               1l, "teste", "email", "123"
        );
        when(gateway.cadastraCliente(
               expected
        )).thenReturn(expected);

        Cliente current = useCase.cadastraCliente(expected);

        assertEquals(expected, current);
    }
}
