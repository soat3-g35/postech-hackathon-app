package br.com.fiap.pos.soat3.medico.application.gateways;

import br.com.fiap.pos.soat3.medico.domain.entity.Medico;

import java.util.List;

public interface MedicoGateway {

    List<Medico> buscaMedico(String especialidade);
}
