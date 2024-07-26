package br.com.fiap.pos.soat3.medico.infrastructure.gateways.paciente;

import br.com.fiap.pos.soat3.medico.application.gateways.PacienteGateway;

import br.com.fiap.pos.soat3.medico.domain.entity.Paciente;
import br.com.fiap.pos.soat3.medico.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.paciente.PacienteEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.paciente.PacienteRepository;

import java.util.Optional;

public class PacienteRepositoryGateway implements PacienteGateway {
    private final PacienteRepository pacienteRepository;
    private final PacienteEntityMapper pacienteEntityMapper;

    public PacienteRepositoryGateway(PacienteRepository pacienteRepository, PacienteEntityMapper pacienteEntityMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteEntityMapper = pacienteEntityMapper;
    }

    @Override
    public Paciente buscaPaciente(Long id) {
        Optional<PacienteEntity> savedEntity = pacienteRepository.findById(id);
        if (savedEntity.isPresent()) {
            return pacienteEntityMapper.toDomainObj(savedEntity.get());
        } else {
            throw new EntityNotFoundException("Paciente", id.toString());
        }
    }
}
