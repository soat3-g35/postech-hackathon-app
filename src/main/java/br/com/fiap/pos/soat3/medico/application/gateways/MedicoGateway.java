package br.com.fiap.pos.soat3.medico.application.gateways;

import br.com.fiap.pos.soat3.medico.domain.entity.Medico;

public interface MedicoGateway {

    Medico buscaMedico(Long id);
}
