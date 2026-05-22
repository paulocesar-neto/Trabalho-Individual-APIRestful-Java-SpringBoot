package trabalho.individual.api.ClinicaPopular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.EspecialidadeRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.EspecialidadeResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.EspecialidadeService;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping
    public ResponseEntity<List<EspecialidadeResponseDTO>> listar(){
        return ResponseEntity.ok(especialidadeService.listarEspecialidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(especialidadeService.buscarEspecialidadeID(id));
    }

    @PostMapping
    public ResponseEntity<EspecialidadeResponseDTO> inserir(@RequestBody EspecialidadeRequestDTO especialidadeRequest){

        EspecialidadeResponseDTO especialidade = especialidadeService.inserirEspecialidade(especialidadeRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(especialidade);
    }

    @PutMapping
    public ResponseEntity<EspecialidadeResponseDTO> atualizar(@RequestBody EspecialidadeRequestDTO especialidadeRequest,@PathVariable Long id){

        EspecialidadeResponseDTO especialidade = especialidadeService.atualizarEspecialidade(especialidadeRequest, id);

        return ResponseEntity.ok(especialidade);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        especialidadeService.removerEspecialidade(id);

        return ResponseEntity.noContent().build();
    }


}
