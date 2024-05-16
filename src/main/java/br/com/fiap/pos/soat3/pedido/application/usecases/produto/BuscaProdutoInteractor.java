package br.com.fiap.pos.soat3.pedido.application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;

public class BuscaProdutoInteractor {
    private final ProdutoGateway produtoGateway;

    public BuscaProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto buscaProduto(Long id) {
        return produtoGateway.buscaProduto(id);
    }
}
