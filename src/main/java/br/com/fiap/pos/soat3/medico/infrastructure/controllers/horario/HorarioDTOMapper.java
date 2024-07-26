package br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario;

import br.com.fiap.pos.soat3.medico.domain.entity.Horario;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;

public class HorarioDTOMapper {

    public Horario toHorario(HorarioRequest request) {
        return new Horario(
                request.duracao(),
                request.valor(),
                request.diaSemana(),
                request.horaInicio(),
                request.horaFim(),
                new Medico(request.medicoId()));
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
