package br.com.fiap.pos.soat3.medico.infrastructure.config;

import br.com.fiap.pos.soat3.medico.application.gateways.HorarioGateway;
import br.com.fiap.pos.soat3.medico.application.usecases.horario.AlteraHorarioInteractor;
import br.com.fiap.pos.soat3.medico.application.usecases.horario.CadastraHorarioInteractor;
import br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario.HorarioDTOMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario.HorarioMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario.HorarioRepositoryGateway;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico.MedicoEntityMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.AgendaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HorarioBeanConfig {

    @Bean
    CadastraHorarioInteractor cadastraHorarioUseCase(HorarioGateway horarioGateway) {
        return new CadastraHorarioInteractor(horarioGateway);
    }

    @Bean
    AlteraHorarioInteractor alteraHorarioUseCase(HorarioGateway horarioGateway) {
        return new AlteraHorarioInteractor(horarioGateway);
    }
    @Bean
    HorarioGateway horarioGateway(AgendaClient agendaClient, HorarioMapper horarioMapper) {
        return new HorarioRepositoryGateway(agendaClient, horarioMapper);
    }

    @Bean
    HorarioDTOMapper horarioDTOMapper() {
        return new HorarioDTOMapper();
    }

    @Bean
    HorarioMapper horarioMapper() {
        return new HorarioMapper();
    }

}
