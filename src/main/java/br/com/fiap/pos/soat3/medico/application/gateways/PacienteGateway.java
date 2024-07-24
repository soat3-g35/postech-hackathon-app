package br.com.fiap.pos.soat3.medico.application.gateways;

import br.com.fiap.pos.soat3.medico.domain.entity.Paciente;

public interface PacienteGateway {

    Paciente buscaPaciente(Long id);
}
