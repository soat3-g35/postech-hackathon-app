package br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario;

import java.util.List;

public record BuscaPorMedicoResponse(Integer totalDeItens, List<HorarioResponse> produtos) {

}
