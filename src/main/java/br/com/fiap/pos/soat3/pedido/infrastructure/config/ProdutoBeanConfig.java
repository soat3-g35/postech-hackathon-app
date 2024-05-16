package br.com.fiap.pos.soat3.pedido.infrastructure.config;

import br.com.fiap.pos.soat3.pedido.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.pedido.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.AlteraProdutoInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.BuscaProdutoInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.CadastraProdutoInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.produto.DeletaProdutoInteractor;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.produto.ProdutoDTOMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.produto.ProdutoEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.produto.ProdutoRepositoryGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.produto.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoBeanConfig {

    @Bean
    CadastraProdutoInteractor cadastraProdutoUseCase(ProdutoGateway produtoGateway) {
        return new CadastraProdutoInteractor(produtoGateway);
    }

    @Bean
    AlteraProdutoInteractor alteraProdutoUseCase(ProdutoGateway produtoGateway) {
        return new AlteraProdutoInteractor(produtoGateway);
    }

    @Bean
    DeletaProdutoInteractor deletaProdutoUseCase(ProdutoGateway produtoGateway) {
        return new DeletaProdutoInteractor(produtoGateway);
    }

    @Bean
    BuscaProdutoInteractor buscaProdutoUseCase(ProdutoGateway produtoGateway) {
        return new BuscaProdutoInteractor(produtoGateway);
    }

    @Bean
    ProdutoEntityMapper produtoEntityMapper() {
        return new ProdutoEntityMapper();
    }

    @Bean
    ProdutoGateway produtoGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper, CategoriaGateway categoriaGateway) {
        return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper, categoriaGateway);
    }

    @Bean
    BuscaPorCategoriaInteractor buscaPorCategoriaUseCase(ProdutoGateway produtoGateway) {
        return new BuscaPorCategoriaInteractor(produtoGateway);
    }

    @Bean
    ProdutoDTOMapper produtoDTOMapper() {
        return new ProdutoDTOMapper();
    }

    @Bean
    ProdutoRepositoryGateway produtoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper, CategoriaGateway categoriaGateway) {
        return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper, categoriaGateway);
    }


}
