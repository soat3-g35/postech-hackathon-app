package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;

public class CategoriaDTOMapper {

    public CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public Categoria toCategoria(CategoriaRequest request) {
        return new Categoria(request.nome());
    }
}
