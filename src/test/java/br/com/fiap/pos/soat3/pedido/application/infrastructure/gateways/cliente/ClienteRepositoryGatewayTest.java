package br.com.fiap.pos.soat3.pedido.application.infrastructure.gateways.cliente;


import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.cliente.ClienteEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.cliente.ClienteRepositoryGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.cliente.ClienteEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.cliente.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClienteRepositoryGatewayTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteEntityMapper clienteEntityMapper;

    @InjectMocks
    private ClienteRepositoryGateway gateway;

    @Test
    void givenCadastraCliente_shouldReturnCliente() {
        ClienteEntity entity = new ClienteEntity(
                1l, "teste", "email", "cpf"
        );
        Cliente model = new Cliente(
            1l, "teste", "email", "cpf"
        );
        when(clienteEntityMapper.toEntity(model)).thenReturn(entity);
        when(clienteRepository.save(entity)).thenReturn(entity);
        when(clienteEntityMapper.toDomainObj(entity)).thenReturn(model);

        var current = gateway.cadastraCliente(model);

        assertEquals("", model, current);
    }

    @Test
    void givenBuscaClientePorCPF_shouldReturnCliente() {
        ClienteEntity entity = new ClienteEntity(
                1l, "teste", "email", "cpf"
        );
        Cliente model = new Cliente(
                1l, "teste", "email", "cpf"
        );

        when(clienteRepository.findByCpf("cpf")).thenReturn(Optional.of(entity));
        when(clienteEntityMapper.toDomainObj(entity)).thenReturn(model);

        var current = gateway.buscaClientePorCPF("cpf");

        assertEquals("", model, current);
    }
}
