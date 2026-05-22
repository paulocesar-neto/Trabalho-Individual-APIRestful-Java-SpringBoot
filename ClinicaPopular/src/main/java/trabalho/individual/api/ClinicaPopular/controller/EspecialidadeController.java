package trabalho.individual.api.ClinicaPopular.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.EspecialidadeRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.EspecialidadeResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.EspecialidadeService;
import java.util.List;

@Tag(name="Especialidade",description = "Consulta e Cadastra Especialidades")
@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @Operation(summary = "Lista todas as especialidades", description = "Lista todas as especialidade do Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidades encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidades não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })

    @GetMapping
    public ResponseEntity<List<EspecialidadeResponseDTO>> listar(){
        return ResponseEntity.ok(especialidadeService.listarEspecialidades());
    }
    @Operation(summary = "Lista especialidade por ID", description = "Lista a especialidade específica do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade ID não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(especialidadeService.buscarEspecialidadeID(id));
    }

    @Operation(summary = "Inserir especialidade", description = "Insere uma especialidade no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade inserida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade não Encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),
    })
    @PostMapping
    public ResponseEntity<EspecialidadeResponseDTO> inserir(@RequestBody EspecialidadeRequestDTO especialidadeRequest){

        EspecialidadeResponseDTO especialidade = especialidadeService.inserirEspecialidade(especialidadeRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(especialidade);
    }

    @Operation(summary = "Atualizar especialidade", description = "Atualiza os dados de uma especialidade no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),
    })
    @PutMapping
    public ResponseEntity<EspecialidadeResponseDTO> atualizar(@RequestBody EspecialidadeRequestDTO especialidadeRequest,@PathVariable Long id){

        EspecialidadeResponseDTO especialidade = especialidadeService.atualizarEspecialidade(especialidadeRequest, id);

        return ResponseEntity.ok(especialidade);
    }
    @Operation(summary = "Excluir especialidade",description = "Remove uma especialidade do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Especialidade removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Especialidade não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),
    })
    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        especialidadeService.removerEspecialidade(id);

        return ResponseEntity.noContent().build();
    }


}
