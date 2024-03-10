package br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido;

import br.com.fiap.pos.soat3.lanchonete.domain.entity.*;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto.ProdutoEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.itempedido.ItemPedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoEntityMapper {

    private void addItems(Pedido pedido, List<ItemPedidoEntity> itensPedidoEntity) {
        pedido.getItensPedido().forEach(item ->
                itensPedidoEntity.add(
                        new ItemPedidoEntity(
                                new ProdutoEntity(item.getProduto().getId()), item.getQuantidade())
                )
        );
    }

    public static List<ItemPedido> itemPedidoFromEntity(List<ItemPedidoEntity> items) {
        var lista = new ArrayList<ItemPedido>();
        items.forEach(pedido ->
                lista.add(new ItemPedido(
                        new Produto(
                                pedido.getProduto().getId(),
                                pedido.getProduto().getNome(),
                                pedido.getProduto().getDescricao(),
                                pedido.getProduto().getImagem(),
                                new BigDecimal(pedido.getProduto().getValor()),
                                new Categoria(
                                        pedido.getProduto().getCategoria().getId(),
                                        pedido.getProduto().getCategoria().getNome()
                                )

                        ),
                        pedido.getQuantidade()
                ))
        );

        return lista;
    }

    PedidoEntity toEntity(Pedido pedidoDomainObj) {

        PedidoEntity pedidoEntity = new PedidoEntity();
        List<ItemPedidoEntity> itensPedidoEntity = new ArrayList<>();
        addItems(pedidoDomainObj, itensPedidoEntity);
        pedidoEntity.setClientId(pedidoDomainObj.getClienteId());
        pedidoEntity.setItensPedido(itensPedidoEntity);
        pedidoEntity.setDataDeCriacao(LocalDateTime.now());
        pedidoEntity.setTotalPedido(pedidoDomainObj.getTotalPedido());
        pedidoEntity.setStatus(pedidoDomainObj.getStatus().name());
        return pedidoEntity;
    }

    public Pedido toDomain(PedidoEntity pedidoEntity) {
        return new Pedido(
                pedidoEntity.getId(),
                pedidoEntity.getClientId(),
                itemPedidoFromEntity(pedidoEntity.getItensPedido()),
                pedidoEntity.getDataDeCriacao(),
                pedidoEntity.getTotalPedido(),
                StatusPedido.valueOf(pedidoEntity.getStatus())
        );
    }
}
