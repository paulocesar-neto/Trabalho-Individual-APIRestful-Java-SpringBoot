package trabalho.individual.api.ClinicaPopular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.individual.api.ClinicaPopular.database.domain.Prontuario;
import trabalho.individual.api.ClinicaPopular.database.repository.ProntuarioRepository;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ProntuarioRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ProntuarioResponseDTO;
import trabalho.individual.api.ClinicaPopular.exception.RecursoNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProntuarioService {
    @Autowired
    private ProntuarioRepository  prontuarioRepository;

    public List<ProntuarioResponseDTO> listarProntuario(){
        List<Prontuario> prontuarios = prontuarioRepository.findAll();
        List<ProntuarioResponseDTO> prontuarioDTO = new ArrayList<ProntuarioResponseDTO>();

        for (Prontuario prontuario:prontuarios){
            prontuarioDTO.add(new ProntuarioResponseDTO(prontuario));
        }
        return  prontuarioDTO;
    }

     public ProntuarioResponseDTO buscarProntuarioID(Long id){
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Prontuário não Encontrado"));

        return new ProntuarioResponseDTO(prontuario);
     }


    public ProntuarioResponseDTO inserirProntuario (ProntuarioRequestDTO prontuarioDTO){


        Prontuario prontuario = new Prontuario();

        prontuario.setNumero(prontuario.getNumero());
        prontuario.setPrescricao(prontuarioDTO.getPrescricao());
        prontuario.setAlergia(prontuarioDTO.getAlergia());
        prontuario.setMedicamento(prontuarioDTO.getMedicamento());
        prontuario.setDataHoraAtendimento(prontuarioDTO.getDataHoraAtendimento());

        prontuario = prontuarioRepository.save(prontuario);

        return new ProntuarioResponseDTO(prontuarioRepository.save(prontuario));
    }

    public ProntuarioResponseDTO atualizarProntuario (ProntuarioRequestDTO prontuarioDTO, Long id){

        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente Não Encontrado"));

        prontuario.setNumero(prontuarioDTO.getNumero());
        prontuario.setPrescricao(prontuarioDTO.getPrescricao());
        prontuario.setAlergia(prontuarioDTO.getAlergia());
        prontuario.setMedicamento(prontuarioDTO.getMedicamento());
        prontuario.setDataHoraAtendimento(prontuarioDTO.getDataHoraAtendimento());

        prontuario = prontuarioRepository.save(prontuario);
        return new ProntuarioResponseDTO(prontuario);

    }

    public void removerProntuario (Long id){
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() ->new RecursoNaoEncontradoException("Prontuario não encontrado"));

        prontuarioRepository.delete(prontuario);
    }
}
