package br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico;

import br.com.fiap.pos.soat3.medico.application.gateways.MedicoGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import br.com.fiap.pos.soat3.medico.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoRepository;

import java.util.Optional;

public class MedicoRepositoryGateway implements MedicoGateway {
    private final MedicoRepository medicoRepository;
    private final MedicoEntityMapper medicoEntityMapper;

    public MedicoRepositoryGateway(MedicoRepository medicoRepository, MedicoEntityMapper medicoEntityMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoEntityMapper = medicoEntityMapper;
    }

    @Override
    public Medico buscaMedico(Long id) {
        Optional<MedicoEntity> savedEntity = medicoRepository.findById(id);
        if (savedEntity.isPresent()) {
            return medicoEntityMapper.toDomainObj(savedEntity.get());
        } else {
            throw new EntityNotFoundException("Medico", id.toString());
        }
    }
}
