package application.infrastructure.controllers.cliente;

import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente.ClienteDTOMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente.ClienteRequest;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente.ClienteResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClienteDTOMapperTest {

    private ClienteDTOMapper mapper = new ClienteDTOMapper();

    @Test
    public void givenRequest_whenMapper_shouldReturnModel() {
        ClienteRequest response = new ClienteRequest(
                1l, "teste", "email", "cpf"
        );

        Cliente expected = new Cliente(
                1l, "teste", "email", "cpf"
        );

        Cliente result = mapper.toCliente(response);

        assertEquals(expected.getNome(), result.getNome());
    }

    @Test
    public void givenModel_whenMapper_shouldReturnResponse() {
        ClienteResponse expected = new ClienteResponse(
                1l, "teste", "email", "cpf"
        );

        Cliente model = new Cliente(
                1l, "teste", "email", "cpf"
        );

        ClienteResponse result = mapper.toResponse(model);

        assertEquals(expected, result);
    }
}
