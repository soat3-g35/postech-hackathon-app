package br.com.fiap.pos.soat3.medico.infrastructure.gateways.consulta;

import br.com.fiap.pos.soat3.medico.application.gateways.ConsultaGateway;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.AgendaClient;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.ConfirmaConsultaRequest;

public class ConsultaRepositoryGateway implements ConsultaGateway {

    private final AgendaClient agendaClient;

    public ConsultaRepositoryGateway(AgendaClient agendaClient) {
        this.agendaClient = agendaClient;
    }

    @Override
    public void confirmaConsulta(Long id, boolean confirmada) {
        agendaClient.confirmaConsulta(id, new ConfirmaConsultaRequest(confirmada));
    }
}
