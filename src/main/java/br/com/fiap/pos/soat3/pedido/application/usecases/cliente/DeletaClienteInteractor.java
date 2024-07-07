package br.com.fiap.pos.soat3.pedido.application.usecases.cliente;

import br.com.fiap.pos.soat3.pedido.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;
public class DeletaClienteInteractor {
    private final ClienteGateway clienteGateway;

    public DeletaClienteInteractor(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Boolean deletaCliente(String cpf) {
        return clienteGateway.deletaClientePorCPF(cpf);
    }
}
