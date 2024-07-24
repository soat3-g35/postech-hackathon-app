package br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario;

import br.com.fiap.pos.soat3.medico.domain.entity.Horario;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.horario.HorarioEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoEntity;

public class HorarioEntityMapper {
    public HorarioEntity toEntity(Horario horarioDomainObj) {
        return new HorarioEntity(horarioDomainObj.getId(),
                horarioDomainObj.getDuracao(),
                horarioDomainObj.getValor(),
                horarioDomainObj.getDiaSemana(),
                horarioDomainObj.getHoraInicio(),
                horarioDomainObj.getHoraFim(),
                new MedicoEntity(horarioDomainObj.getMedico().getId()));
    }

    public Horario toDomainObj(HorarioEntity horarioEntity) {
        return new Horario(
                horarioEntity.getDuracao(),
                horarioEntity.getValor(),
                horarioEntity.getDiaSemana(),
                horarioEntity.getHoraInicio(),
                horarioEntity.getHoraFim(),
                new Medico(horarioEntity.getMedico().getId()));
    }
}
