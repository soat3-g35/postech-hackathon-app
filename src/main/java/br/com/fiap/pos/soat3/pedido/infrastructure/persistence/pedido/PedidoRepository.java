package br.com.fiap.pos.soat3.pedido.infrastructure.persistence.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    @Query(value = "select * from pedido where status <> :status", nativeQuery = true)
    List<PedidoEntity> findByStatusNot(String status);

    @Query(value = "select * from pedido where status in ('PREPARACAO', 'RECEBIDO')", nativeQuery = true)
    List<PedidoEntity> findByProducaoStatus();
}
