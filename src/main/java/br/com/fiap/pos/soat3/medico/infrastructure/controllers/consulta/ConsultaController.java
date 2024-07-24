package br.com.fiap.pos.soat3.medico.infrastructure.controllers.consulta;

import br.com.fiap.pos.soat3.medico.application.usecases.consulta.ConfirmaConsultaInteractor;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")
public class ConsultaController {

    private final ConfirmaConsultaInteractor confirmaConsultaInteractor;

    public ConsultaController(ConfirmaConsultaInteractor confirmaConsultaInteractor) {
        this.confirmaConsultaInteractor = confirmaConsultaInteractor;
    }

    @PutMapping("/{id}")
    public ResponseEntity confirmaConsulta(@PathVariable Long id, @NotEmpty @RequestBody ConfirmaConsultaRequest confirmada) {
        confirmaConsultaInteractor.confirmaConsulta(id, confirmada.confirmada());
        return ResponseEntity.noContent().build();
    }

}
