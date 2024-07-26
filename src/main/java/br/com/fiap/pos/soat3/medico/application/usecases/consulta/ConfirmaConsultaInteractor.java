package br.com.fiap.pos.soat3.medico.application.usecases.consulta;

import br.com.fiap.pos.soat3.medico.application.gateways.ConsultaGateway;

public class ConfirmaConsultaInteractor {
    private final ConsultaGateway consultaGateway;

    public ConfirmaConsultaInteractor(ConsultaGateway consultaGateway) {
        this.consultaGateway = consultaGateway;
    }

    public void confirmaConsulta(Long id, boolean confirmada) { consultaGateway.confirmaConsulta(id, confirmada);}
}
