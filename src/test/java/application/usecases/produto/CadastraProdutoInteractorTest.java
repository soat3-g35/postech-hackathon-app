package application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.CadastraProdutoInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CadastraProdutoInteractorTest {

    @Mock
    private ProdutoGateway gateway;

    @InjectMocks
    private CadastraProdutoInteractor useCase;

    @Test
    void givenCorrectData_whenCadastraProduto_shouldReturnProduto() {
        Produto produto = new Produto();
        when(gateway.cadastraProduto(produto)).thenReturn(produto);

        Produto current = useCase.cadastraProduto(produto);

        assertEquals(produto, current);
    }
}
