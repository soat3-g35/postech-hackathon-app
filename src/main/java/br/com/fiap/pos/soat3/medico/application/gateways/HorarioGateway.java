package br.com.fiap.pos.soat3.medico.application.gateways;

import br.com.fiap.pos.soat3.medico.domain.entity.Horario;

public interface HorarioGateway {

    Horario cadastraHorario(Horario horario);
    Horario alteraHorario(Long id, Horario horario);

}
