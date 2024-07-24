package br.com.fiap.pos.soat3.medico.application.usecases.medico;

import br.com.fiap.pos.soat3.medico.application.gateways.MedicoGateway;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;

import java.util.List;

public class BuscaMedicoInteractor {
    private final MedicoGateway medicoGateway;

    public BuscaMedicoInteractor(MedicoGateway medicoGateway) {
        this.medicoGateway = medicoGateway;
    }

    public List<Medico> buscaMedico(String especialidade) { return  medicoGateway.buscaMedico(especialidade);}
}
