package br.com.fiap.pos.soat3.pedido.application.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria.CategoriaDTOMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria.CategoriaRequest;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria.CategoriaResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CategoriaDTOMapperTest {

    private CategoriaDTOMapper mapper = new CategoriaDTOMapper();

    @Test
    void givenRequest_whenMapper_shouldReturnModel() {
        CategoriaRequest response = new CategoriaRequest(
                "teste"
        );

        Categoria expected = new Categoria(
                1l, "teste"
        );

        Categoria result = mapper.toCategoria(response);

        assertEquals(expected.getNome(), result.getNome());
    }

    @Test
    void givenModel_whenMapper_shouldReturnResponse() {
        CategoriaResponse expected = new CategoriaResponse(
                1l, "teste"
        );

        Categoria model = new Categoria(
                1l, "teste"
        );

        CategoriaResponse result = mapper.toResponse(model);

        assertEquals(expected, result);
    }
}
