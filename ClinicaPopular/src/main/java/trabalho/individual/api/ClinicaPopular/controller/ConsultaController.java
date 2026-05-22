package trabalho.individual.api.ClinicaPopular.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ConsultaRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ConsultaResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.ConsultaService;
import java.util.List;

@Tag(name="Consultas",description = "Consulta e Cadastro de Consultas")
@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Operation(summary = "Lista todas as consulta",description = "Lista todas as consultas do Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultas encontradas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consultas não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listar(){
        return ResponseEntity.ok(consultaService.listarConsultas());
    }

    @Operation(summary = "Lista consulta por ID",description = "Lista a consulta específica do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consulta ID não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(consultaService.buscarConsultaID(id));
    }

    @Operation(summary = "Inserir consulta", description = "Insere uma consulta no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta inserida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consulta não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> inserir(@RequestBody ConsultaRequestDTO consultaRequest){

        ConsultaResponseDTO consulta = consultaService.inserirConsulta(consultaRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }

    @Operation(summary = "Atualizar consulta", description = "Atualiza os dados de uma consulta no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consulta não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @PutMapping
    public ResponseEntity<ConsultaResponseDTO> atualizar(@RequestBody ConsultaRequestDTO consultaRequest,@PathVariable Long id){
        ConsultaResponseDTO consulta = consultaService.atualizarConsulta(consultaRequest, id);
        return ResponseEntity.ok(consulta);
    }

    @Operation(summary = "Excluir consulta", description = "Remove uma consulta do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consulta ID não encontrada"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        consultaService.removerConsulta(id);

        return ResponseEntity.noContent().build();
    }

}
