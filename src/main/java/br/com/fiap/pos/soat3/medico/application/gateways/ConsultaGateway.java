package br.com.fiap.pos.soat3.medico.application.gateways;

import br.com.fiap.pos.soat3.medico.domain.entity.Consulta;

public interface ConsultaGateway {

    Consulta cadastraConsulta(Consulta consulta);
    void confirmaConsulta(Long id, boolean confirmada);
}
