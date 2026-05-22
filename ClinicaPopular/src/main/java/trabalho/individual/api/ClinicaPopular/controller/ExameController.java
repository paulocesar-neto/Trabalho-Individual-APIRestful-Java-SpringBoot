package trabalho.individual.api.ClinicaPopular.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ExameRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ExameResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.ExameService;
import java.util.List;

@Tag(name="Exame",description = "Consulta e cadastro de Exames")
@RestController
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @Operation(
            summary = "Lista todos os exames",
            description = "Lista todos os  exame  do Banco de Dados "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exames encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Exames não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @GetMapping
    public ResponseEntity<List<ExameResponseDTO>> listar(){
        return ResponseEntity.ok(exameService.listarExames());
    }

    @Operation(summary = "Lista exame por ID", description = "Lista o exame específico do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exame encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Exame ID não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ExameResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(exameService.buscarExameID(id));
    }
    @Operation(
            summary = "Inserir exame",
            description = "Insere um exame no Banco de Dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exame inserido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Exame não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),
    })
    @PostMapping
    public ResponseEntity<ExameResponseDTO> inserir(@RequestBody ExameRequestDTO exameRequest){

        ExameResponseDTO exame = exameService.inserirExame(exameRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(exame);
    }

    @Operation(summary = "Atualizar exame", description = "Atualiza os dados de um exame no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exame atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Exame não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),
    })
    @PutMapping
    public ResponseEntity<ExameResponseDTO> atualizar(@RequestBody ExameRequestDTO exameRequest,@PathVariable Long id){

        ExameResponseDTO exame = exameService.atualizarExame(exameRequest, id);

        return ResponseEntity.ok(exame);
    }
    @Operation(
            summary = "Excluir exame",
            description = "Remove um exame do Banco de Dados pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exame removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Exame não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),
    })
    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        exameService.removerExame(id);

        return ResponseEntity.noContent().build();
    }
}
