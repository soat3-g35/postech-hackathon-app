package br.com.fiap.pos.soat3.medico.infrastructure.gateways.consulta;

import br.com.fiap.pos.soat3.medico.domain.entity.Consulta;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import br.com.fiap.pos.soat3.medico.domain.entity.Paciente;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.consulta.ConsultaEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoEntity;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.paciente.PacienteEntity;

public class ConsultaEntityMapper {

    public ConsultaEntity toEntity(Consulta consultaDomainObj) {
        return new ConsultaEntity(consultaDomainObj.getId(),
                consultaDomainObj.getDataConsulta(),
                consultaDomainObj.getLinkConsulta(),
                consultaDomainObj.getJustificativaCancelamento(),
                consultaDomainObj.isConfirmadaMedico(),
                consultaDomainObj.isCanceladaPaciente(),
                new MedicoEntity(consultaDomainObj.getMedico().getId()),
                new PacienteEntity(consultaDomainObj.getPaciente().getId()));
    }

    public Consulta toDomainObj(ConsultaEntity consultaEntity) {
        return new Consulta(
                consultaEntity.getDataConsulta(),
                consultaEntity.getLinkConsulta(),
                consultaEntity.getJustificativaCancelamento(),
                consultaEntity.isConfirmadaMedico(),
                consultaEntity.isCanceladaPaciente(),
                new Medico(consultaEntity.getMedico().getId()),
                new Paciente(consultaEntity.getPaciente().getId()));
    }
}
