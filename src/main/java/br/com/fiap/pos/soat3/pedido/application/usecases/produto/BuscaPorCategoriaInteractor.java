package br.com.fiap.pos.soat3.pedido.application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;

import java.util.List;

public class BuscaPorCategoriaInteractor {
    private final ProdutoGateway produtoGateway;

    public BuscaPorCategoriaInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public List<Produto> buscaPorCategoria(Long id) {
        return produtoGateway.buscaPorCategoria(id);
    }
}
