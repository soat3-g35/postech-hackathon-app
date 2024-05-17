package application.usecases.categoria;

import br.com.fiap.pos.soat3.pedido.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.categoria.CadastraCategoriaInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CadastraCategoriaInteractorTest {

    @Mock
    private  CategoriaGateway gateway;

    @InjectMocks
    private CadastraCategoriaInteractor useCase;

    @Test
    void givenCorrectData_whenCadastraCategoria_shouldReturnCategoriaModel() {
        Categoria expected = new Categoria(
                1l, "teste"
        );
        when(gateway.cadastraCategoria(expected)).thenReturn(expected);

        Categoria currentCategoria = useCase.cadastraCategoria(expected);

        assertEquals(expected, currentCategoria);
    }
}
