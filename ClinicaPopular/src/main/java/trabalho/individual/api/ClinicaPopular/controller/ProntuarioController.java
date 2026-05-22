package trabalho.individual.api.ClinicaPopular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ProntuarioRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ProntuarioResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.ProntuarioService;
import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

        @Autowired
        private ProntuarioService prontuarioService;

        @GetMapping
        public ResponseEntity<List<ProntuarioResponseDTO>> listar(){
            return ResponseEntity.ok(prontuarioService.listarProntuario());
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProntuarioResponseDTO> buscarPorId(@PathVariable Long id){
            return ResponseEntity.ok(prontuarioService.buscarProntuarioID(id));
        }

        @PostMapping
        public ResponseEntity<ProntuarioResponseDTO> inserir(@RequestBody ProntuarioRequestDTO prontuarioRequest){

            ProntuarioResponseDTO prontuario = prontuarioService.inserirProntuario(prontuarioRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body(prontuario);

        }

        @PutMapping
        public ResponseEntity<ProntuarioResponseDTO> atualizar(@RequestBody ProntuarioRequestDTO prontuarioRequest,@PathVariable Long id){

            ProntuarioResponseDTO prontuario = prontuarioService.atualizarProntuario(prontuarioRequest, id);

            return ResponseEntity.ok(prontuario);
        }

        @DeleteMapping
        public ResponseEntity<Void> remover(@PathVariable Long id){
            prontuarioService.removerProntuario(id);

            return ResponseEntity.noContent().build();
        }



}
