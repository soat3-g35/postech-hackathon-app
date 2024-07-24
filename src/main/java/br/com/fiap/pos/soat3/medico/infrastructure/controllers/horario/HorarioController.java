package br.com.fiap.pos.soat3.medico.infrastructure.controllers.horario;

import br.com.fiap.pos.soat3.medico.application.usecases.horario.AlteraHorarioInteractor;
import br.com.fiap.pos.soat3.medico.application.usecases.horario.CadastraHorarioInteractor;
import br.com.fiap.pos.soat3.medico.domain.entity.Horario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
public class HorarioController {

    private final AlteraHorarioInteractor alteraHorarioUseCase;
    private final CadastraHorarioInteractor cadastraHorarioUseCase;
    private final HorarioDTOMapper horarioDTOMapper;

    public HorarioController(AlteraHorarioInteractor alteraHorarioUseCase, CadastraHorarioInteractor cadastraHorarioUseCase, HorarioDTOMapper horarioDTOMapper) {
        this.alteraHorarioUseCase = alteraHorarioUseCase;
        this.cadastraHorarioUseCase = cadastraHorarioUseCase;
        this.horarioDTOMapper = horarioDTOMapper;
    }

    @PostMapping
    public ResponseEntity<HorarioResponse> cadastraHorario(@Valid @RequestBody HorarioRequest horarioRequest) {
        Horario horarioBussinessObj = horarioDTOMapper.toHorario(horarioRequest);
        return ResponseEntity.ok(horarioDTOMapper.toResponse(cadastraHorarioUseCase.cadastraHorario(horarioBussinessObj)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioResponse> alteraHorario(@PathVariable Long id, @NotEmpty @RequestBody HorarioRequest horarioRequest) {
        Horario horarioBussinessObj = horarioDTOMapper.toHorario(horarioRequest);
        return ResponseEntity.ok(horarioDTOMapper.toResponse(alteraHorarioUseCase.alteraHorario(id, horarioBussinessObj)));
    }
}
