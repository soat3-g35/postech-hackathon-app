package application.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria.CategoriaResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente.ClienteDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente.ClienteRequest;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente.ClienteResponse;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoRequest;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProdutoDTOMapperTest {

    private ProdutoDTOMapper mapper = new ProdutoDTOMapper();

    @Test
    public void givenRequest_whenMapper_shouldReturnModel() {
        ProdutoRequest response = new ProdutoRequest(
                "nome", "desc", "picture",
                "200", 1l
        );

        Produto expected = new Produto(
                "nome", "desc", "picture",
                new BigDecimal(200), new Categoria(
                "teste"
        )
        );

        Produto result = mapper.toProduto(response);

        assertEquals(expected.getNome(), result.getNome());
    }

    @Test
    public void givenModel_whenMapper_shouldReturnResponse() {
        ProdutoResponse response = new ProdutoResponse(
                null, "nome", "desc", "picture",
                "200", new CategoriaResponse(
                null, "teste"
        )
        );

        Produto model = new Produto(
                "nome", "desc", "picture",
                new BigDecimal(200), new Categoria(
                "teste"
        )
        );

        ProdutoResponse result = mapper.toResponse(model);

        assertEquals(response, result);
    }
}
