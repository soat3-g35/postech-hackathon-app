package br.com.fiap.pos.soat3.pedido.infrastructure.config;

import br.com.fiap.pos.soat3.pedido.application.gateways.EnviaConfirmacaoGateway;
import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.pagamento.EnviaConfirmacaoInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.ConsultaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.ListaPedidosInteractor;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido.PedidoDTOMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.pedido.PedidoEntityMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.gateways.pedido.PedidoRepositoryGateway;
import br.com.fiap.pos.soat3.pedido.infrastructure.integration.EnviaConfirmacaoMock;
import br.com.fiap.pos.soat3.pedido.infrastructure.integration.MVPCliente;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.itempedido.ItemPedidoRepository;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.pedido.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {

    @Bean
    AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase(PedidoGateway pedidoGateway) {
        return new AtualizaStatusPedidoInteractor(pedidoGateway);
    }

    @Bean
    PedidoDTOMapper pedidoDTOMapper() {
        return new PedidoDTOMapper();
    }

    @Bean
    ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase(PedidoGateway pedidoGateway) {
        return new ConsultaStatusPedidoInteractor(pedidoGateway);
    }

    @Bean
    ListaPedidosInteractor listaPedidosUseCase(PedidoGateway pedidoGateway) {
        return new ListaPedidosInteractor(pedidoGateway);
    }

    @Bean
    EnviaConfirmacaoInteractor enviaConfirmacaoUseCase(EnviaConfirmacaoGateway enviaConfirmacaoGateway, PedidoGateway pedidoGateway) {
        return new EnviaConfirmacaoInteractor(enviaConfirmacaoGateway, pedidoGateway);
    }

    @Bean
    EnviaConfirmacaoMock enviaConfirmacaoMock(MVPCliente mvpCliente) {
        return new EnviaConfirmacaoMock(mvpCliente);
    }

    @Bean
    PedidoEntityMapper pedidoEntityMapper() {
        return new PedidoEntityMapper();
    }

    @Bean
    PedidoRepositoryGateway pedidoRepositoryGateway(PedidoRepository pedidoRepository,
                                                    ItemPedidoRepository itemPedidoRepository,
                                                    PedidoEntityMapper pedidoEntityMapper) {
        return new PedidoRepositoryGateway(pedidoRepository, itemPedidoRepository, pedidoEntityMapper);
    }
}
