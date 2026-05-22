package trabalho.individual.api.ClinicaPopular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.PacienteRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.PacienteResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listar(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPacienteID(id));
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> inserir(@RequestBody PacienteRequestDTO pacienteRequest){

        PacienteResponseDTO paciente = pacienteService.inserir(pacienteRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);

    }

    @PutMapping
     public ResponseEntity<PacienteResponseDTO> atualizar(@RequestBody PacienteRequestDTO pacienteRequest,@PathVariable Long id){

        PacienteResponseDTO pacienteDto = pacienteService.atualizar(pacienteRequest, id);

        return ResponseEntity.ok(pacienteDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
              pacienteService.remover(id);

      return ResponseEntity.noContent().build();
    }
}
