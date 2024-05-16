package br.com.fiap.pos.soat3.pedido.application.gateways;

import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;

public interface CategoriaGateway {
    Categoria cadastraCategoria(Categoria categoria);

    Categoria buscaCategoria(Long id);
}
