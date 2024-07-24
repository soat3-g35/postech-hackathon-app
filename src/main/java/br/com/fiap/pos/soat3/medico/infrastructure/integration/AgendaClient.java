package br.com.fiap.pos.soat3.medico.infrastructure.integration;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "agenda-client", url = "${agenda-client.agenda-url}")
@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface AgendaClient {

    @PostMapping("/horario")
    IntegrationHorarioResponse cadastraHorario(@RequestBody IntegrationHorarioRequest integrationHorarioRequest);

    @PutMapping("/horario/{horarioId}")
    IntegrationHorarioResponse alteraHorario(@PathVariable("horarioId") Long horarioId, IntegrationHorarioRequest integrationHorarioRequest);

    @PutMapping("/consulta/{consultaId}")
    void confirmaConsulta(@PathVariable("consultaId") Long consultaId, ConfirmaConsultaRequest confirmada);
}
