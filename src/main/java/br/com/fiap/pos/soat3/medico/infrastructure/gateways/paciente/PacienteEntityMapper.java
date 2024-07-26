package br.com.fiap.pos.soat3.medico.infrastructure.gateways.paciente;

import br.com.fiap.pos.soat3.medico.domain.entity.Paciente;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.paciente.PacienteEntity;

public class PacienteEntityMapper {
    public PacienteEntity toEntity(Paciente pacienteDomainObj) {
        return new PacienteEntity(pacienteDomainObj.getId(),
                pacienteDomainObj.getNome(),
                pacienteDomainObj.getEmail(),
                pacienteDomainObj.getCpf(),
                pacienteDomainObj.getEndereco());
    }

    public Paciente toDomainObj(PacienteEntity pacienteEntity) {
        return new Paciente(pacienteEntity.getId(),
                pacienteEntity.getNome(),
                pacienteEntity.getEmail(),
                pacienteEntity.getCpf(),
                pacienteEntity.getEndereco());
    }
}
