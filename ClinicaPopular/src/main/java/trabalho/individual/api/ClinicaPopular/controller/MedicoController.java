package trabalho.individual.api.ClinicaPopular.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.MedicoRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.MedicoResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.MedicoService;

import java.util.List;
@Tag(name="Medico",description = "Consulta e Cadastro de Médicos")
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Operation(
            summary = "Lista todos os Médicos",
            description = "Lista todos médicos do Banco de Dados "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médicos encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médicos não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listar(){
        return ResponseEntity.ok(medicoService.listarMedicos());
    }

    @Operation(summary = "Lista médico por ID", description = "Lista o médico específico do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médico ID não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(medicoService.buscarMedicoID(id));
    }

    @Operation(summary = "Inserir médico", description = "Insere um médico no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico inserido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Medico não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @PostMapping
    public ResponseEntity<MedicoResponseDTO> inserir(@RequestBody MedicoRequestDTO medicoRequest){

        MedicoResponseDTO medico = medicoService.inserirMedico(medicoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }

    @Operation(
            summary = "Atualizar médico",
            description = "Atualiza os dados de um médico no Banco de Dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),

    })
    @PutMapping
    public ResponseEntity<MedicoResponseDTO> atualizar(@RequestBody MedicoRequestDTO medicoRequest,@PathVariable Long id){

        MedicoResponseDTO medico = medicoService.atualizarMedico(medicoRequest, id);

        return ResponseEntity.ok(medico);
    }

    @Operation(summary = "Excluir médico", description = "Remove um médico do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médico ID não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação"),
    })
    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        medicoService.removerMedico(id);

        return ResponseEntity.noContent().build();
    }
}
