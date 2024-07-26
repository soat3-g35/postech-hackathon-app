package br.com.fiap.pos.soat3.medico.infrastructure.config;
import br.com.fiap.pos.soat3.medico.application.gateways.HorarioGateway;
import br.com.fiap.pos.soat3.medico.application.gateways.MedicoGateway;
import br.com.fiap.pos.soat3.medico.application.usecases.horario.AlteraHorarioInteractor;
import br.com.fiap.pos.soat3.medico.application.usecases.medico.BuscaMedicoInteractor;
import br.com.fiap.pos.soat3.medico.infrastructure.controllers.medico.MedicoDTOMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico.MedicoEntityMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico.MedicoRepositoryGateway;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicoBeanConfig {

    @Bean
    MedicoEntityMapper medicoEntityMapper() {
        return new MedicoEntityMapper();
    }

    @Bean
    MedicoGateway medicoGateway(MedicoRepository medicoRepository, MedicoEntityMapper medicoEntityMapper) {
        return new MedicoRepositoryGateway(medicoRepository, medicoEntityMapper);
    }

    @Bean
    BuscaMedicoInteractor buscaMedicoUseCase(MedicoGateway medicoGateway) {
        return new BuscaMedicoInteractor(medicoGateway);
    }

    @Bean
    MedicoDTOMapper medicoDTOMapper() {
        return new MedicoDTOMapper();
    }
}
