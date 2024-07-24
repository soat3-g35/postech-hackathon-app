package br.com.fiap.pos.soat3.medico.infrastructure.controllers.consulta;


import br.com.fiap.pos.soat3.medico.domain.entity.Consulta;
import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import br.com.fiap.pos.soat3.medico.domain.entity.Paciente;

public class ConsultaDTOMapper {
    public Consulta toConsulta(ConsultaRequest request) {
        return new Consulta(
                request.dataConsulta(),
                new Medico(request.medicoId()),
                new Paciente(request.pacienteId()));
    }
}