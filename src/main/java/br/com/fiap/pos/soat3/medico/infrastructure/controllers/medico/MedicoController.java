package br.com.fiap.pos.soat3.medico.infrastructure.controllers.medico;

import br.com.fiap.pos.soat3.medico.application.usecases.medico.BuscaMedicoInteractor;

import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final BuscaMedicoInteractor buscaMedicoInteractor;
    private final MedicoDTOMapper medicoDTOMapper;

    public MedicoController(BuscaMedicoInteractor buscaMedicoInteractor, MedicoDTOMapper medicoDTOMapper) {
        this.buscaMedicoInteractor = buscaMedicoInteractor;
        this.medicoDTOMapper = medicoDTOMapper;
    }

    @GetMapping("/busca")
    public ResponseEntity<List<MedicoResponse>> buscaMedico(@RequestParam String especialidade) {
        List<Medico> medicos = buscaMedicoInteractor.buscaMedico(especialidade);
        return ResponseEntity.ok(medicos.stream().map(medicoDTOMapper::toResponse).collect(Collectors.toList()));
    }

}
