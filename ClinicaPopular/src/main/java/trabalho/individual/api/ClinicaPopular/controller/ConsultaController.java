package trabalho.individual.api.ClinicaPopular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ConsultaRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ConsultaResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.ConsultaService;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listar(){
        return ResponseEntity.ok(consultaService.listarConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(consultaService.buscarConsultaID(id));
    }

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> inserir(@RequestBody ConsultaRequestDTO consultaRequest){

        ConsultaResponseDTO consulta = consultaService.inserirConsulta(consultaRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }

    @PutMapping
    public ResponseEntity<ConsultaResponseDTO> atualizar(@RequestBody ConsultaRequestDTO consultaRequest,@PathVariable Long id){

        ConsultaResponseDTO consulta = consultaService.atualizarConsulta(consultaRequest, id);

        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        consultaService.removerConsulta(id);

        return ResponseEntity.noContent().build();
    }

}
