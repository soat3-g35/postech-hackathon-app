package br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario;

import br.com.fiap.pos.soat3.medico.application.gateways.HorarioGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Horario;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.AgendaClient;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.IntegrationHorarioRequest;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.IntegrationHorarioResponse;

public class HorarioRepositoryGateway implements HorarioGateway {

    private final AgendaClient agendaClient;
    private final HorarioMapper horarioMapper;

    public HorarioRepositoryGateway(AgendaClient agendaClient, HorarioMapper horarioMapper) {
        this.agendaClient = agendaClient;
        this.horarioMapper = horarioMapper;
    }

    @Override
    public Horario cadastraHorario(Horario horario) {
        IntegrationHorarioRequest integrationHorarioRequest = new IntegrationHorarioRequest(
                horario.getDuracao(), horario.getValor(), horario.getDiaSemana(), horario.getHoraInicio(), horario.getHoraFim(), horario.getMedico().getId());
        IntegrationHorarioResponse response = agendaClient.cadastraHorario(integrationHorarioRequest);
        return horarioMapper.toDomain(response);
    }

    @Override
    public Horario alteraHorario(Long id, Horario horario) {
        IntegrationHorarioRequest integrationHorarioRequest = new IntegrationHorarioRequest(
                horario.getDuracao(), horario.getValor(), horario.getDiaSemana(), horario.getHoraInicio(), horario.getHoraFim(), horario.getMedico().getId());
        IntegrationHorarioResponse response = agendaClient.alteraHorario(id, integrationHorarioRequest);
        return horarioMapper.toDomain(response);
    }
}
