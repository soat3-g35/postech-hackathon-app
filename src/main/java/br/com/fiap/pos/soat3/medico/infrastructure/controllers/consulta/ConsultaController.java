package br.com.fiap.pos.soat3.medico.infrastructure.controllers.consulta;

import br.com.fiap.pos.soat3.medico.application.usecases.consulta.CadastraConsultaInteractor;
import br.com.fiap.pos.soat3.medico.application.usecases.consulta.ConfirmaConsultaInteractor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConfirmaConsultaInteractor confirmaConsultaInteractor;
    private final CadastraConsultaInteractor cadastraConsultaInteractor;
    private final ConsultaDTOMapper consultaDTOMapper;

    public ConsultaController(ConfirmaConsultaInteractor confirmaConsultaInteractor, CadastraConsultaInteractor cadastraConsultaInteractor, ConsultaDTOMapper consultaDTOMapper) {
        this.confirmaConsultaInteractor = confirmaConsultaInteractor;
        this.cadastraConsultaInteractor = cadastraConsultaInteractor;
        this.consultaDTOMapper = consultaDTOMapper;
    }

    @PutMapping("/{id}")
    public ResponseEntity confirmaConsulta(@PathVariable Long id, @NotEmpty @RequestBody ConfirmaConsultaRequest confirmada) {
        confirmaConsultaInteractor.confirmaConsulta(id, confirmada.confirmada());
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity cadastraConsulta(@Valid @RequestBody ConsultaRequest consultaRequest) {
        cadastraConsultaInteractor.cadastraConsulta(consultaDTOMapper.toConsulta(consultaRequest));
        return ResponseEntity.noContent().build();
    }

}
