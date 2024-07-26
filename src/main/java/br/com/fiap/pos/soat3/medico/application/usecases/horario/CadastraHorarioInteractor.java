package br.com.fiap.pos.soat3.medico.application.usecases.horario;

import br.com.fiap.pos.soat3.medico.application.gateways.HorarioGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Horario;

public class CadastraHorarioInteractor {

    private final HorarioGateway horarioGateway;

    public CadastraHorarioInteractor(HorarioGateway horarioGateway) {
        this.horarioGateway = horarioGateway;
    }

    public Horario cadastraHorario(Horario horario) {
        return horarioGateway.cadastraHorario(horario);
    }
}
