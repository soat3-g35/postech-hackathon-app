package br.com.fiap.pos.soat3.pedido.application.infrastructure.gateways.categoria;

import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.categoria.CategoriaEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.categoria.CategoriaEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CategoriaEntityMapperTest {

    @InjectMocks
    CategoriaEntityMapper mapper;

    @Test
    void toEntity_shouldReturnCategoriaEntity() {
        Categoria model = new Categoria(
                "teste"
        );
        CategoriaEntity expected = new CategoriaEntity(
                "teste"
        );

        var current = mapper.toEntity(model);

        assertEquals("", expected.getNome(), current.getNome());
        assertEquals("", expected.getId(), current.getId());
    }

    @Test
    void toDomainObj_shouldReturnCategoriaEntity() {
        Categoria expected = new Categoria(
                "teste"
        );
        CategoriaEntity model = new CategoriaEntity(
                "teste"
        );

        var current = mapper.toDomainObj(model);

        assertEquals("", expected.getNome(), current.getNome());
    }
}
