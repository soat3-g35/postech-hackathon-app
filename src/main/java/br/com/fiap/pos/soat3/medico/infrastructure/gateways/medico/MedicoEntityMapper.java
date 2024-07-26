package br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico;

import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoEntity;

public class MedicoEntityMapper {
    public MedicoEntity toEntity(Medico medicoDomainObj) {
        return new MedicoEntity(medicoDomainObj.getId(),
                medicoDomainObj.getNome(),
                medicoDomainObj.getCrm(),
                medicoDomainObj.getEspecialidade(),
                medicoDomainObj.getEndereco());
    }

    public Medico toDomainObj(MedicoEntity medicoEntity) {
        return new Medico(medicoEntity.getId(),
                medicoEntity.getNome(),
                medicoEntity.getCrm(),
                medicoEntity.getEspecialidade(),
                medicoEntity.getEndereco());
    }
}
