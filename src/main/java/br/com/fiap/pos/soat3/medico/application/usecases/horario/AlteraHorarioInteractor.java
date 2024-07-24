package br.com.fiap.pos.soat3.medico.application.usecases.horario;

import br.com.fiap.pos.soat3.medico.application.gateways.HorarioGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Horario;

public class AlteraHorarioInteractor {
    private final HorarioGateway horarioGateway;

    public AlteraHorarioInteractor(HorarioGateway horarioGateway) {
        this.horarioGateway = horarioGateway;
    }

    public Horario alteraHorario(Long id, Horario horario) {
        return horarioGateway.alteraHorario(id,
                horario);
    }
}
