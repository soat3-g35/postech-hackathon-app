package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.produto;

import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria.CategoriaResponse;

public record ProdutoResponse(Long id, String nome, String descricao, String imagem, String valor,
                              CategoriaResponse categoria) {
}
