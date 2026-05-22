package trabalho.individual.api.ClinicaPopular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.MedicoRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.MedicoResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.MedicoService;

import java.util.List;
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listar(){
        return ResponseEntity.ok(medicoService.listarMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(medicoService.buscarMedicoID(id));
    }

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> inserir(@RequestBody MedicoRequestDTO medicoRequest){

        MedicoResponseDTO medico = medicoService.inserirMedico(medicoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }

    @PutMapping
    public ResponseEntity<MedicoResponseDTO> atualizar(@RequestBody MedicoRequestDTO medicoRequest,@PathVariable Long id){

        MedicoResponseDTO medico = medicoService.atualizarMedico(medicoRequest, id);

        return ResponseEntity.ok(medico);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        medicoService.removerMedico(id);

        return ResponseEntity.noContent().build();
    }
}
