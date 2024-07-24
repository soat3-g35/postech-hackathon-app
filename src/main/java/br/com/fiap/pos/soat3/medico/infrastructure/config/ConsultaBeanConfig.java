package br.com.fiap.pos.soat3.medico.infrastructure.config;
import br.com.fiap.pos.soat3.medico.application.gateways.ConsultaGateway;
import br.com.fiap.pos.soat3.medico.application.usecases.consulta.CadastraConsultaInteractor;
import br.com.fiap.pos.soat3.medico.application.usecases.consulta.ConfirmaConsultaInteractor;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.consulta.ConsultaEntityMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.consulta.ConsultaRepositoryGateway;
import br.com.fiap.pos.soat3.medico.infrastructure.gateways.medico.MedicoEntityMapper;
import br.com.fiap.pos.soat3.medico.infrastructure.persistence.consulta.ConsultaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultaBeanConfig {

    @Bean
    ConsultaEntityMapper consultaEntityMapper() {
        return new ConsultaEntityMapper();
    }

    @Bean
    ConfirmaConsultaInteractor confirmaConsultaInteractor(ConsultaGateway consultaGateway) {
        return new ConfirmaConsultaInteractor(consultaGateway);
    }

    @Bean
    CadastraConsultaInteractor cadastraConsultaInteractor(ConsultaGateway consultaGateway) {
        return new CadastraConsultaInteractor(consultaGateway);
    }

    @Bean
    ConsultaGateway consultaGateway(ConsultaRepository consultaRepository, ConsultaEntityMapper consultaEntityMapper) {
        return new ConsultaRepositoryGateway(consultaRepository, consultaEntityMapper);
    }
}
