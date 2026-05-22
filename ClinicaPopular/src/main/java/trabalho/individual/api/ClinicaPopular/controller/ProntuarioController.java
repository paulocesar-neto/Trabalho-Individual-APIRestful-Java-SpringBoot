package trabalho.individual.api.ClinicaPopular.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ProntuarioRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ProntuarioResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.ProntuarioService;
import java.util.List;

@Tag(name ="Prontuario",description = "Cadastro e consulta de Prontuarios")
@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

        @Autowired
        private ProntuarioService prontuarioService;

    @Operation(summary = "Lista todos os Prontuarios ",description = "Lista todos os Prontuarios do Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Prontuarios encontrados com sucesso"),
            @ApiResponse(responseCode = "404",description = "Prontuarios não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
        @GetMapping
        public ResponseEntity<List<ProntuarioResponseDTO>> listar(){
            return ResponseEntity.ok(prontuarioService.listarProntuario());
        }

    @Operation(summary = "Lista prontuario por ID ",description = "Lista um prontuario especifico do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Prontuario ID encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Prontuario ID não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    } )

        @GetMapping("/{id}")
        public ResponseEntity<ProntuarioResponseDTO> buscarPorId(@PathVariable Long id){
            return ResponseEntity.ok(prontuarioService.buscarProntuarioID(id));
        }

    @Operation(summary = "Inseri um Prontuario ",description = "Inseri um prontuario no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Prontuario cadastrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Prontuario ID não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    } )
        @PostMapping
        public ResponseEntity<ProntuarioResponseDTO> inserir(@RequestBody ProntuarioRequestDTO prontuarioRequest){

            ProntuarioResponseDTO prontuario = prontuarioService.inserirProntuario(prontuarioRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body(prontuario);

        }

    @Operation(summary = " Atualiza prontuario ",description = "Atualiza prontuario no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Prontuario atualizado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Prontuario não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    } )
        @PutMapping
        public ResponseEntity<ProntuarioResponseDTO> atualizar(@RequestBody ProntuarioRequestDTO prontuarioRequest,@PathVariable Long id){

            ProntuarioResponseDTO prontuario = prontuarioService.atualizarProntuario(prontuarioRequest, id);

            return ResponseEntity.ok(prontuario);
        }

    @Operation(summary = "Deleta Prontuario ",description = "Deleta prontuario do Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Paciente encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Paciente ID não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    } )
        @DeleteMapping
        public ResponseEntity<Void> remover(@PathVariable Long id){
            prontuarioService.removerProntuario(id);

            return ResponseEntity.noContent().build();
        }



}
