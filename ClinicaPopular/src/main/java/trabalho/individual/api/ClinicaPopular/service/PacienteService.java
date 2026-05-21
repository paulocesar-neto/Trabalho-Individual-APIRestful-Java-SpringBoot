package trabalho.individual.api.ClinicaPopular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.database.repository.PacienteRepository;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.PacienteResponseDTO;
import trabalho.individual.api.ClinicaPopular.exception.EmailException;

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

    public Paciente inserir (Paciente paciente){
        Paciente p = pacienteRepository.findByEmail(paciente.getEmail());
        if(p != null){
            throw new EmailException("Email já cadastrado");
        }
        return pacienteRepository.save(paciente);
    }


    public Paciente atualizar (Paciente paciente){

    }


}
