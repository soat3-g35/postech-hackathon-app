package br.com.fiap.pos.soat3.pedido.infrastructure.persistence.cliente;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByCpf(String cpf);
}