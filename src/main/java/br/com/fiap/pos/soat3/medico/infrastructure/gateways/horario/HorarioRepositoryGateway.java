package br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario;

import br.com.fiap.pos.soat3.medico.application.gateways.HorarioGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Horario;
import br.com.fiap.pos.soat3.medico.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.horario.HorarioEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.horario.HorarioRepository;

import java.util.Optional;

public class HorarioRepositoryGateway implements HorarioGateway {

    private final HorarioRepository horarioRepository;
    private final HorarioEntityMapper horarioEntityoMapper;

    public HorarioRepositoryGateway(HorarioRepository horarioRepository, HorarioEntityMapper horarioEntityoMapper) {
        this.horarioRepository = horarioRepository;
        this.horarioEntityoMapper = horarioEntityoMapper;
    }

    @Override
    public Horario cadastraHorario(Horario horario) {
        horarioRepository.save(horarioEntityoMapper.toEntity(horario));
        return horario;
    }

    @Override
    public Horario alteraHorario(Long id, Horario horario) {
        Optional<HorarioEntity> savedEntity = horarioRepository.findById(id);
        if (savedEntity.isPresent()) {
            horarioRepository.save(horarioEntityoMapper.toEntity(horario));
            return horario;
        } else {
            throw new EntityNotFoundException("Horario", id.toString());
        }
    }
}
