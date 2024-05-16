package application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.AlteraProdutoInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlteraProdutoInteractorTest {

    @Mock
    private ProdutoGateway gateway;

    @InjectMocks
    private AlteraProdutoInteractor useCase;

    @Test
    public void givenCorrectData_whenAlteraProduto_shouldReturnProdutoModel() {
        Produto expected = new Produto();
        when(gateway.alteraProduto(expected)).thenReturn(expected);

        Produto current = useCase.alteraProduto(expected);

        assertEquals(expected, current);
    }
}
