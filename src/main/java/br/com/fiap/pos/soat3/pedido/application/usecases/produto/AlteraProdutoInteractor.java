package br.com.fiap.pos.soat3.pedido.application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;

public class AlteraProdutoInteractor {
    private final ProdutoGateway produtoGateway;

    public AlteraProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto alteraProduto(Produto produto) {
        return produtoGateway.alteraProduto(produto);
    }
}
