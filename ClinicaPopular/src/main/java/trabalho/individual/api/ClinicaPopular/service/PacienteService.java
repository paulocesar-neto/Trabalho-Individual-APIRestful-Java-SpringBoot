package trabalho.individual.api.ClinicaPopular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.database.repository.PacienteRepository;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.PacienteRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.PacienteResponseDTO;
import trabalho.individual.api.ClinicaPopular.exception.EmailException;
import trabalho.individual.api.ClinicaPopular.exception.RecursoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteResponseDTO> listarPacientes(){

        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteResponseDTO> pacienteDTO = new ArrayList<PacienteResponseDTO>();

        for (Paciente paciente:pacientes){
            pacienteDTO.add(new PacienteResponseDTO(paciente));
        }
        return  pacienteDTO;
    }

    public PacienteResponseDTO buscarPacienteID(Long id){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Prontuário não Encontrado"));

        return new PacienteResponseDTO(paciente);
    }

    public PacienteResponseDTO inserir (PacienteRequestDTO pacienteDTO){
        Paciente p = pacienteRepository.findByEmail(pacienteDTO.getEmail());
        if(pacienteRepository.findByEmail(p.getEmail())!=null){
            throw new EmailException("Email já cadastrado");
        }
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTelefone(pacienteDTO.getTelefone());

        return new PacienteResponseDTO(pacienteRepository.save(paciente));
    }

    public PacienteResponseDTO atualizar (PacienteRequestDTO pacienteDTO, Long id){

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente Não Encontrado"));

        Paciente buscarEmail = pacienteRepository.findByEmail(pacienteDTO.getEmail());

        if (buscarEmail != null && !buscarEmail.equals(buscarEmail.getId())) {
            throw new EmailException("Email já cadastrado");
        }

        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setTelefone(pacienteDTO.getTelefone());

        paciente = pacienteRepository.save(paciente);

        return new PacienteResponseDTO(paciente);

    }

     public void remover (Long id){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() ->new RecursoNaoEncontradoException("Paciente não encontrado"));

        pacienteRepository.delete(paciente);
     }

}
