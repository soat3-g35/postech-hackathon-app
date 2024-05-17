package application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscaPorCategoriaInteractorTest {

    @Mock
    private ProdutoGateway gateway;

    @InjectMocks
    private BuscaPorCategoriaInteractor useCase;

    @Test
    void givenCorrectData_whenBuscaProdutoPorCategoria_shouldReturnListaDeProdutos() {
        Produto produto = new Produto();
        ArrayList<Produto> lista = new ArrayList<>();
        lista.add(produto);
        when(gateway.buscaPorCategoria(2L)).thenReturn(lista);

        List<Produto> current = useCase.buscaPorCategoria(2L);

        assertEquals(lista, current);
    }
}
