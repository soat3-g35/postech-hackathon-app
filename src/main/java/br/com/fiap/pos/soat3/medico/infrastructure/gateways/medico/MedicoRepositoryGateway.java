package br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico;

import br.com.fiap.pos.soat3.medico.application.gateways.MedicoGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MedicoRepositoryGateway implements MedicoGateway {
    private final MedicoRepository medicoRepository;
    private final MedicoEntityMapper medicoEntityMapper;

    public MedicoRepositoryGateway(MedicoRepository medicoRepository, MedicoEntityMapper medicoEntityMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoEntityMapper = medicoEntityMapper;
    }

    @Override
    public List<Medico> buscaMedico(String especialidade) {
        return medicoRepository.findByEspecialidade(especialidade).stream().map(medicoEntityMapper::toDomainObj).collect(Collectors.toList());
    }
}
