package br.com.fiap.pos.soat3.medico.application.usecases.consulta;

import br.com.fiap.pos.soat3.medico.application.gateways.ConsultaGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Consulta;

public class CadastraConsultaInteractor {

    private final ConsultaGateway consultaGateway;

    public CadastraConsultaInteractor(ConsultaGateway consultaGateway) {
        this.consultaGateway = consultaGateway;
    }

    public Consulta cadastraConsulta(Consulta consulta) {
        consultaGateway.cadastraConsulta(consulta);
        return consulta;
    }
}