package br.com.fiap.pos.soat3.pedido.application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.DeletaProdutoInteractor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeletaProdutoInteractorTest {

    @Mock
    private ProdutoGateway gateway;

    @InjectMocks
    private DeletaProdutoInteractor useCase;

    @Test
    void givenCorrectData_whenCadastraProduto_shouldReturnProduto() {
        doNothing().when(gateway).deletaProduto(123l);

       useCase.deletaProduto(123l);

        // Assert
        verify(gateway).deletaProduto(123l);
    }
}
