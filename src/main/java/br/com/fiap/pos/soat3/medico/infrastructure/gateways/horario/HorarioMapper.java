package br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario;

import br.com.fiap.pos.soat3.medico.domain.entity.Horario;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario.HorarioResponse;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.IntegrationHorarioResponse;

public class HorarioMapper {
    public Horario toDomain(IntegrationHorarioResponse integrationHorarioResponse) {
        return new Horario(
                integrationHorarioResponse.duracao(),
                integrationHorarioResponse.valor(),
                integrationHorarioResponse.diaSemana(),
                integrationHorarioResponse.horaInicio(),
                integrationHorarioResponse.horaFim(),
                new Medico(integrationHorarioResponse.medicoId()));
    }

    public HorarioResponse toResponse(Horario horario) {
        return new HorarioResponse(
                horario.getId(),
                horario.getDuracao(),
                horario.getValor(),
                horario.getDiaSemana(),
                horario.getHoraInicio(),
                horario.getHoraFim(),
                horario.getMedico().getId());
    }
}
