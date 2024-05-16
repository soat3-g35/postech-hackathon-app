package br.com.fiap.pos.soat3.pedido.application.usecases.cliente;

import br.com.fiap.pos.soat3.pedido.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;

public class CadastraClienteInteractor {
    private final ClienteGateway clienteGateway;

    public CadastraClienteInteractor(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente cadastraCliente(Cliente cliente) {
        return clienteGateway.cadastraCliente(cliente);
    }
}
