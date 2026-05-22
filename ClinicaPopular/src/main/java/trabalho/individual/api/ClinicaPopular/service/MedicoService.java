package trabalho.individual.api.ClinicaPopular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.database.repository.MedicoRepository;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.MedicoRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.MedicoResponseDTO;
import trabalho.individual.api.ClinicaPopular.exception.EmailException;
import trabalho.individual.api.ClinicaPopular.exception.RecursoNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoResponseDTO> listarMedicos(){

        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoResponseDTO> medicoDTO = new ArrayList<MedicoResponseDTO>();

        for (Medico medico : medicos){
            medicoDTO.add(new MedicoResponseDTO(medico));
        }
        return  medicoDTO;
    }

    public MedicoResponseDTO buscarMedicoID(Long id){
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Médico não Encontrado"));

        return new MedicoResponseDTO(medico);
    }

    public MedicoResponseDTO inserirMedico (MedicoRequestDTO medicoDTO){
        Medico m = medicoRepository.findByEmail(medicoDTO.getEmail());
        if(medicoRepository.findByEmail(m.getEmail())!=null){
            throw new EmailException("Email já cadastrado");
        }
        Medico medico = new Medico();
        medico.setNome(medicoDTO.getNome());
        medico.setCrm(medicoDTO.getCrm());
        medico.setTelefone(medicoDTO.getTelefone());
        medico.setEmail(medicoDTO.getEmail());
        medico.setConsulta(medicoDTO.getConsultas());
        medico.setEspecialidade(medicoDTO.getEspecialidades());
        medico.setProntuario(medicoDTO.getProntuario());

        return new MedicoResponseDTO(medicoRepository.save(medico));
    }

    public MedicoResponseDTO atualizarMedico (MedicoRequestDTO medicoDTO, Long id){

        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Medico Não Encontrado"));

       Medico buscarEmail = medicoRepository.findByEmail(medicoDTO.getEmail());

        if (buscarEmail != null && !buscarEmail.equals(buscarEmail.getId())) {
            throw new EmailException("Email já cadastrado");
        }

        medico.setNome(medicoDTO.getNome());
        medico.setCrm(medicoDTO.getCrm());
        medico.setEmail(medicoDTO.getEmail());
        medico.setTelefone(medicoDTO.getTelefone());
        medico.setTelefone(medicoDTO.getTelefone());
        medico.setConsulta(medicoDTO.getConsultas());
        medico.setEspecialidade(medicoDTO.getEspecialidades());
        medico.setProntuario(medicoDTO.getProntuario());

        medico = medicoRepository.save(medico);

        return new MedicoResponseDTO(medico);
    }

    public void removerMedico (Long id){
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() ->new RecursoNaoEncontradoException("Medico não encontrado"));

        medicoRepository.delete(medico);
    }
}
