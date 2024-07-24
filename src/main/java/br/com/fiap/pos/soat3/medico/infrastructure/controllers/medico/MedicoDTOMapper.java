package br.com.fiap.pos.soat3.medico.infrastructure.controllers.medico;

import br.com.fiap.pos.soat3.medico.domain.entity.Medico;

public class MedicoDTOMapper {

    public MedicoResponse toResponse(Medico medico) {
        return new MedicoResponse(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
