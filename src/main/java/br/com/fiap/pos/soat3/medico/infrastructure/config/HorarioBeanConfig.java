package br.com.fiap.pos.soat3.medico.infrastructure.config;

import br.com.fiap.pos.soat3.medico.application.gateways.HorarioGateway;
import br.com.fiap.pos.soat3.medico.application.usecases.horario.AlteraHorarioInteractor;
import br.com.fiap.pos.soat3.medico.application.usecases.horario.CadastraHorarioInteractor;
import br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario.HorarioDTOMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.controllers.consulta.ConsultaDTOMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.consulta.ConsultaEntityMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario.HorarioEntityMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.horario.HorarioRepositoryGateway;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.horario.HorarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HorarioBeanConfig {

    @Bean
    HorarioEntityMapper horarioEntityMapper() {
        return new HorarioEntityMapper();
    }

    @Bean
    CadastraHorarioInteractor cadastraHorarioUseCase(HorarioGateway horarioGateway) {
        return new CadastraHorarioInteractor(horarioGateway);
    }

    @Bean
    AlteraHorarioInteractor alteraHorarioUseCase(HorarioGateway horarioGateway) {
        return new AlteraHorarioInteractor(horarioGateway);
    }
    @Bean
    HorarioGateway horarioGateway(HorarioRepository horarioRepository, HorarioEntityMapper horarioEntityoMapper) {
        return new HorarioRepositoryGateway(horarioRepository, horarioEntityoMapper);
    }

    @Bean
    HorarioDTOMapper horarioDTOMapper() {
        return new HorarioDTOMapper();
    }

    @Bean
    ConsultaDTOMapper horarioMapper() {
        return new ConsultaDTOMapper();
    }

}
