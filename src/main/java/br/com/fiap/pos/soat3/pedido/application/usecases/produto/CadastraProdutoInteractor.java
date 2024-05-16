package br.com.fiap.pos.soat3.pedido.application.usecases.produto;

import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;

public class CadastraProdutoInteractor {
    private final ProdutoGateway produtoGateway;


    public CadastraProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto cadastraProduto(Produto produto) {
        return produtoGateway.cadastraProduto(produto);
    }
}
