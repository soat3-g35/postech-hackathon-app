package br.com.fiap.pos.soat3.medico.infrastructure.gateways.consulta;

import br.com.fiap.pos.soat3.medico.application.gateways.ConsultaGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Consulta;
import br.com.fiap.pos.soat3.medico.infrastructure.config.exception.EntityNotFoundException;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.consulta.ConsultaEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.consulta.ConsultaRepository;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoEntity;

import java.util.Optional;

public class ConsultaRepositoryGateway implements ConsultaGateway {

    private final ConsultaRepository consultaRepository;
    private final ConsultaEntityMapper consultaEntityMapper;

    public ConsultaRepositoryGateway(ConsultaRepository consultaRepository, ConsultaEntityMapper consultaEntityMapper) {
        this.consultaRepository = consultaRepository;
        this.consultaEntityMapper = consultaEntityMapper;
    }


    @Override
    public Consulta cadastraConsulta(Consulta consulta) {
        consultaRepository.save(consultaEntityMapper.toEntity(consulta));
        return consulta;
    }

    @Override
    public void confirmaConsulta(Long id, boolean confirmada) {
        Optional<ConsultaEntity> savedEntity = consultaRepository.findById(id);
        if (savedEntity.isPresent()) {
            ConsultaEntity consultaEntity = savedEntity.get();
            consultaEntity.setConfirmadaMedico(confirmada);
            consultaRepository.save(consultaEntity);
        } else {
            throw new EntityNotFoundException("Consulta", id.toString());
        }

    }
}
