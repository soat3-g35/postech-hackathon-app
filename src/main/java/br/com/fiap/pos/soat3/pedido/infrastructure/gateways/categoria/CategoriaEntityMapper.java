package br.com.fiap.pos.soat3.pedido.infrastructure.gateways.categoria;

import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.categoria.CategoriaEntity;

public class CategoriaEntityMapper {
    public CategoriaEntity toEntity(Categoria categoriaDomainObj) {

        return new CategoriaEntity(categoriaDomainObj.getNome());
    }

    public Categoria toDomainObj(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getNome());
    }
}
