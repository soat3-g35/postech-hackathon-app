package br.com.fiap.pos.soat3.pedido.application.infrastructure.gateways.cliente;

import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.cliente.ClienteEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.cliente.ClienteEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@ExtendWith(MockitoExtension.class)
public class ClienteEntityMapperTest {

    @InjectMocks
    ClienteEntityMapper mapper;

    @Test
    void toEntity_shouldReturnClienteEntity() {
        Cliente model = new Cliente(
                1l, "teste", "email", "cpf"
        );
        ClienteEntity expected = new ClienteEntity(
                1l, "teste", "email", "cpf"
        );

        var current = mapper.toEntity(model);

        assertEquals("", expected.getNome(), current.getNome());
        assertEquals("", expected.getEmail(), current.getEmail());
        assertEquals("", expected.getCpf(), current.getCpf());
    }

    @Test
    void toDomainObj_shouldReturnClienteEntity() {
        Cliente expected = new Cliente(
                1l, "teste", "email", "cpf"
        );
        ClienteEntity model = new ClienteEntity(
                1l, "teste", "email", "cpf"
        );

        var current = mapper.toDomainObj(model);

        assertEquals("", expected.getNome(), current.getNome());
        assertEquals("", expected.getEmail(), current.getEmail());
        assertEquals("", expected.getCPF(), current.getCPF());
    }
}
