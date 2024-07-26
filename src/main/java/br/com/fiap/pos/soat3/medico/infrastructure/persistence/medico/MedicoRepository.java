package br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface MedicoRepository extends CrudRepository<MedicoEntity, Long> {

    @Query(value = "SELECT * FROM medico WHERE especialidade=?",nativeQuery = true)
    List<MedicoEntity> findByEspecialidade(String especialidade);
}
