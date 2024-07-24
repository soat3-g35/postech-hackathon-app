package br.com.fiap.pos.soat3.medico.infrastructure.controllers.medico;

import br.com.fiap.pos.soat3.medico.application.usecases.medico.BuscaMedicoInteractor;

import br.com.fiap.pos.soat3.medico.domain.entity.Medico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final BuscaMedicoInteractor buscaMedicoInteractor;
    private final MedicoDTOMapper medicoDTOMapper;

    public MedicoController(BuscaMedicoInteractor buscaMedicoInteractor, MedicoDTOMapper medicoDTOMapper) {
        this.buscaMedicoInteractor = buscaMedicoInteractor;
        this.medicoDTOMapper = medicoDTOMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> buscaMedico(@PathVariable Long id) {
        Medico medico = buscaMedicoInteractor.buscaMedico(id);
        return ResponseEntity.ok(medicoDTOMapper.toResponse(medico));
    }

}
