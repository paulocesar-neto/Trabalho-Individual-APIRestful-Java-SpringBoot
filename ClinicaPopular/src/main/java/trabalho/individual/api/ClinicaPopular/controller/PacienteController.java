package trabalho.individual.api.ClinicaPopular.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.PacienteRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.PacienteResponseDTO;
import trabalho.individual.api.ClinicaPopular.service.PacienteService;

import java.util.List;

@Tag(name ="Paciente",description = "Cadastro e consulta de Pacientes")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Operation(summary = "Lista todos os paciente cadastrados",description = "Lista paciente do Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Paciente encontrados com sucesso"),
            @ApiResponse(responseCode = "404",description = "Paciente não encontrado")
    } )
    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listar(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @Operation(summary = "Lista paciente por ID ",description = "Lista o paciente especifico do Banco de Dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Paciente encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Paciente ID não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    } )
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPacienteID(id));
    }

    @Operation(summary = "Cadastra um Paciente ",description = "Cadastra um paciente no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Paciente cadastrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> inserir(@RequestBody PacienteRequestDTO pacienteRequest){

        PacienteResponseDTO paciente = pacienteService.inserir(pacienteRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    @Operation(summary = "Atualiza um Paciente ",description = "Atualiza um paciente do Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Paciente atualizado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @PutMapping
     public ResponseEntity<PacienteResponseDTO> atualizar(@RequestBody PacienteRequestDTO pacienteRequest,@PathVariable Long id){

        PacienteResponseDTO pacienteDto = pacienteService.atualizar(pacienteRequest, id);

        return ResponseEntity.ok(pacienteDto);
    }

    @Operation(summary = "Deleta um Paciente ",description = "Deleta um paciente no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Paciente deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "401", description = "Erro de Autenticação")
    })
    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
              pacienteService.remover(id);

      return ResponseEntity.noContent().build();
    }
}
