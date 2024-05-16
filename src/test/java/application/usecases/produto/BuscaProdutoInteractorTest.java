package application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.BuscaProdutoInteractor;
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
public class BuscaProdutoInteractorTest {

    @Mock
    private ProdutoGateway gateway;

    @InjectMocks
    private BuscaProdutoInteractor useCase;

    @Test
    public void givenCorrectData_whenBuscaProduto_shouldReturnProduto() {
        Produto produto = new Produto();
        when(gateway.buscaProduto(2L)).thenReturn(produto);

        Produto current = useCase.buscaProduto(2L);

        assertEquals(produto, current);
    }
}
