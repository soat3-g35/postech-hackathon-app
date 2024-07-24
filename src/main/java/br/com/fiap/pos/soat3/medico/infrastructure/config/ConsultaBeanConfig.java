package br.com.fiap.pos.soat3.medico.infrastructure.config;
import br.com.fiap.pos.soat3.medico.application.gateways.ConsultaGateway;
import br.com.fiap.pos.soat3.medico.application.gateways.MedicoGateway;
import br.com.fiap.pos.soat3.medico.application.usecases.consulta.ConfirmaConsultaInteractor;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.consulta.ConsultaRepositoryGateway;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico.MedicoEntityMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico.MedicoRepositoryGateway;
import br.com.fiap.pos.soat3.medico.infrastructure.integration.AgendaClient;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.medico.MedicoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultaBeanConfig {

    @Bean
    ConfirmaConsultaInteractor CcnfirmaConsultaInteractor(ConsultaGateway consultaGateway) {
        return new ConfirmaConsultaInteractor(consultaGateway);
    }

    @Bean
    ConsultaGateway consultaGateway(AgendaClient agendaClient) {
        return new ConsultaRepositoryGateway(agendaClient);
    }
}
