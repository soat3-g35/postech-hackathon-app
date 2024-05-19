package br.com.fiap.pos.soat3.pedido.application.infrastructure.gateways.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import br.com.fiap.pos.soat3.pedido.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.produto.ProdutoEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.produto.ProdutoRepositoryGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.categoria.CategoriaEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.produto.ProdutoEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.produto.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProdutoRepositoryGatewayTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoEntityMapper produtoEntityMapper;

    @Mock
    private CategoriaGateway categoriaGateway;

    @InjectMocks
    private ProdutoRepositoryGateway gateway;

    @Test
    void givenBuscaPorCategoria_shouldReturnListProdutos() {
        List<ProdutoEntity> produtoEntities = new ArrayList<>();
        ProdutoEntity entity = new ProdutoEntity(
                1l
        );

        List<Produto> lista = new ArrayList<>();
        Produto prd = new Produto(
                1l
        );
        lista.add(prd);
        produtoEntities.add(entity);
        when(produtoRepository.findByCategoriaId(1l)).thenReturn(produtoEntities);
        when(produtoEntityMapper.toDomainListObj(produtoEntities)).thenReturn(lista);

        var current = gateway.buscaPorCategoria(1l);

        assertEquals("", lista, current);
    }

    @Test
    void givenBuscaProduto_shouldReturnProduto() {
        List<ProdutoEntity> produtoEntities = new ArrayList<>();
        ProdutoEntity entity = new ProdutoEntity(
                1l
        );
        produtoEntities.add(entity);


        List<Produto> lista = new ArrayList<>();
        Produto prd = new Produto(
                1l
        );
        lista.add(prd);


        when(produtoRepository.findById(1l)).thenReturn(Optional.of(entity));
        when(produtoEntityMapper.toDomainObj(entity)).thenReturn(prd);

        // Act
        Produto result = gateway.buscaProduto(1l);

        // Assert
        assertEquals("", prd, result);
        verify(produtoRepository).findById(1l);
        verify(produtoEntityMapper).toDomainObj(entity);
    }

    @Test
    void givenCadastraProduto_shouldReturnProduto() {
        ProdutoEntity entity = new ProdutoEntity(
                "teste",
                "desc",
                "img",
                "20",
                new CategoriaEntity()
        );

        Categoria cat = new Categoria(
                1l,
                "teste"
        );

        Produto prd = new Produto(
                1l,
                "teste",
                "desc",
                "img",
                new BigDecimal(20.0),
                cat

        );
        when(categoriaGateway.buscaCategoria(1l)).thenReturn(cat);
        when(produtoEntityMapper.toEntity(prd)).thenReturn(entity);
        when(produtoRepository.save(entity)).thenReturn(entity);
        when(produtoEntityMapper.toDomainObj(entity)).thenReturn(prd);

        var current = gateway.cadastraProduto(prd);

        assertEquals("", prd, current);
    }

    @Test
    void givenDeletaProduto_withPresentProduct_shouldDeleteCorrectly() {
        ProdutoEntity entity = new ProdutoEntity(
                "teste",
                "desc",
                "img",
                "20",
                new CategoriaEntity()
        );

        Categoria cat = new Categoria(
                1l,
                "teste"
        );

        when(produtoRepository.findById(1l)).thenReturn(Optional.of(entity));
        doNothing().when(produtoRepository).deleteById(1l);

        gateway.deletaProduto(1l);

        verify(produtoRepository).deleteById(1l);
    }

    @Test()
    void givenDeletaProduto_ProductNotExists_shouldntDelete() {
        when(produtoRepository.findById(1l)).thenReturn(Optional.ofNullable(null));

        assertThrows(EntityNotFoundException.class, () -> {
            gateway.deletaProduto(1l);
        });

        verify(produtoRepository, never()).deleteById(1l);
    }
    @Test()
    void givenAlteraProduto_shoudAlterar() {
        Produto produto = new Produto(1L);
        produto.setValor(new BigDecimal(10));
        produto.setNome("teste");
        produto.setDescricao("img");
        produto.setImagem("img");
        produto.setCategoria(new Categoria(1L, "nome"));

        ProdutoEntity entity = new ProdutoEntity(
                "teste",
                "desc",
                "img",
                "20",
                new CategoriaEntity()
        );

        when(produtoRepository.findById(1l)).thenReturn(Optional.of(entity));
        when(produtoEntityMapper.updateEntity(entity, produto)).thenReturn(entity);
        when(produtoRepository.save(entity)).thenReturn(entity);
        when(produtoEntityMapper.toDomainObj(entity)).thenReturn(produto);

        Produto productReturn = gateway.alteraProduto(produto);

        assertEquals(" ", produto.getId().toString(), productReturn.getId().toString());
    }

    @Test()
    void givenAlteraProduto_shoudnAlterar() {
        Produto produto = new Produto(1L);
        when(produtoRepository.findById(1l)).thenReturn(Optional.ofNullable(null));

        assertThrows(EntityNotFoundException.class, () -> {
            gateway.alteraProduto(produto);
        });
    }
}
