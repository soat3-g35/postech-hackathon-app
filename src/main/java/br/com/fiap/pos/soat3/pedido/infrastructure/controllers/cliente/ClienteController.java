package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente;

import br.com.fiap.pos.soat3.pedido.application.usecases.cliente.BuscaClientePorCPFInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.cliente.CadastraClienteInteractor;
import br.com.fiap.pos.soat3.pedido.application.usecases.cliente.DeletaClienteInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final CadastraClienteInteractor cadastraClienteUseCase;
    private final BuscaClientePorCPFInteractor buscaClientePorCPFUseCase;
    private final DeletaClienteInteractor deletaClientePorCPFUseCase;
    private final ClienteDTOMapper clienteDTOMapper;

    public ClienteController(CadastraClienteInteractor cadastraClienteUseCase, BuscaClientePorCPFInteractor buscaClientePorCPFUseCase, DeletaClienteInteractor deletaClientePorCPFUseCase, ClienteDTOMapper clienteDTOMapper) {
        this.cadastraClienteUseCase = cadastraClienteUseCase;
        this.buscaClientePorCPFUseCase = buscaClientePorCPFUseCase;
        this.deletaClientePorCPFUseCase = deletaClientePorCPFUseCase;
        this.clienteDTOMapper = clienteDTOMapper;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastraCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente clienteObj = clienteDTOMapper.toCliente(clienteRequest);
        Cliente cliente = cadastraClienteUseCase.cadastraCliente(clienteObj);
        return ResponseEntity.ok(clienteDTOMapper.toResponse(cliente));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscaPorCpf(@PathVariable String cpf) {
        Cliente cliente = buscaClientePorCPFUseCase.bucaClientePorCPF(cpf);
        return ResponseEntity.ok(clienteDTOMapper.toResponse(cliente));
    }

    @DeleteMapping
    public String deletaCliente(@RequestBody ClienteRequest clienteRequest) {
        Boolean cliente = deletaClientePorCPFUseCase.deletaCliente(clienteRequest.CPF());
        return "Cliente deletado do banco de dados";
    }
}
