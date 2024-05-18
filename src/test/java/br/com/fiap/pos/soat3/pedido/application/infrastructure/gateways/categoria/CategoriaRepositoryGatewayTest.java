package br.com.fiap.pos.soat3.pedido.application.infrastructure.gateways.categoria;


import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.categoria.CategoriaEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.categoria.CategoriaRepositoryGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.categoria.CategoriaEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.categoria.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CategoriaRepositoryGatewayTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private CategoriaEntityMapper categoriaEntityMapper;

    @InjectMocks
    private CategoriaRepositoryGateway gateway;

    @Test
    void givenCadastraCategoria_toEntity_shouldReturnCategoria() {
        CategoriaEntity entity = new CategoriaEntity(
                "teste"
        );
        Categoria model = new Categoria(
            "teste"
        );
        when(categoriaEntityMapper.toEntity(model)).thenReturn(entity);
        when(categoriaRepository.save(entity)).thenReturn(entity);
        when(categoriaEntityMapper.toDomainObj(entity)).thenReturn(model);

        var current = gateway.cadastraCategoria(model);

        assertEquals("", model, current);
    }
}
