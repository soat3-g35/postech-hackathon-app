package br.com.fiap.pos.soat3.pedido.application.infrastructure.gateways.produto;

import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.produto.ProdutoEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.categoria.CategoriaEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.produto.ProdutoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProdutoEntityMapperTest {

    @InjectMocks
    ProdutoEntityMapper mapper;

    @Test
    void toEntity_shouldReturnClienteEntity() {
        Produto model = new Produto(
                1l, "nome", "desc", "imagem",
                new BigDecimal(20.00), new Categoria("teste")
        );
        ProdutoEntity expected = new ProdutoEntity(
                "nome", "20", "desc", "imagem",
                 new CategoriaEntity("teste")
        );

        var current = mapper.toEntity(model);

        assertEquals("", expected.getNome(), current.getNome());
        assertEquals("", expected.getValor(), current.getValor());
        assertEquals("", expected.getImagem(), current.getImagem());
    }

    @Test
    void toDomainObj_shouldReturnListProdutoEntity() {
        List<Produto> expectedList = new ArrayList<>();
        Produto prd = new Produto(
                1l, "nome", "desc", "imagem",
                new BigDecimal(20.00), new Categoria("teste")
        );
        expectedList.add(prd);

        List<ProdutoEntity> list = new ArrayList<>();
        ProdutoEntity model = new ProdutoEntity(
                "nome", "20", "desc", "image,",
                new CategoriaEntity("teste")
        );
        list.add(model);

        var current = mapper.toDomainListObj(list);

        assertEquals("", expectedList.size(), current.size());
    }
}
