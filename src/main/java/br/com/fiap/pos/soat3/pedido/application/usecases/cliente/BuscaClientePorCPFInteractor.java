package br.com.fiap.pos.soat3.pedido.application.usecases.cliente;

import br.com.fiap.pos.soat3.pedido.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;

public class BuscaClientePorCPFInteractor {
    private final ClienteGateway clienteGateway;

    public BuscaClientePorCPFInteractor(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente bucaClientePorCPF(String cpf) {
        return clienteGateway.buscaClientePorCPF(cpf);
    }
}
