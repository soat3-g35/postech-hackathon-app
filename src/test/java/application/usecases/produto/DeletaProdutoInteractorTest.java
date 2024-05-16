package application.usecases.produto;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.CadastraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.DeletaProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeletaProdutoInteractorTest {

    @Mock
    private ProdutoGateway gateway;

    @InjectMocks
    private DeletaProdutoInteractor useCase;

    @Test
    public void givenCorrectData_whenCadastraProduto_shouldReturnProduto() {
        doNothing().when(gateway).deletaProduto(123l);

       useCase.deletaProduto(123l);

        // Assert
        verify(gateway).deletaProduto(123l);
    }
}
