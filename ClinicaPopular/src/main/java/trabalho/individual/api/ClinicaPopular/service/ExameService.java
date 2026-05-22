package trabalho.individual.api.ClinicaPopular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.individual.api.ClinicaPopular.database.domain.Exame;

import trabalho.individual.api.ClinicaPopular.database.repository.ExameRepository;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ExameRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ExameResponseDTO;

import trabalho.individual.api.ClinicaPopular.exception.RecursoNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public List<ExameResponseDTO> listarExames(){
        List<Exame> exames = exameRepository.findAll();
        List<ExameResponseDTO> examesDTO = new ArrayList<ExameResponseDTO>();

        for (Exame exame:exames){
            examesDTO.add(new ExameResponseDTO(exame));
        }
        return  examesDTO;
    }

    public ExameResponseDTO buscarExameID(Long id){
        Exame exame = exameRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Exame não Encontrado"));

        return new ExameResponseDTO(exame);
    }


    public ExameResponseDTO inserirExame (ExameRequestDTO exameDTO){


        Exame exame = new Exame();

        exame.setExames(exameDTO.getExames());
        exame.setStatus(exameDTO.getStatus());
        exame.setMotivo(exameDTO.getMotivo());
        exame.setPaciente(exameDTO.getPaciente());


        exame = exameRepository.save(exame);

        return new ExameResponseDTO(exameRepository.save(exame));
    }

    public ExameResponseDTO atualizarExame (ExameRequestDTO exameDTO, Long id){

        Exame exame = exameRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Exame Não Encontrado"));

        exame.setExames(exameDTO.getExames());
        exame.setStatus(exameDTO.getStatus());
        exame.setMotivo(exameDTO.getMotivo());
        exame.setPaciente(exameDTO.getPaciente());

        exame = exameRepository.save(exame);
        return new ExameResponseDTO(exame);

    }

    public void removerExame (Long id){
        Exame exame = exameRepository.findById(id)
                .orElseThrow(() ->new RecursoNaoEncontradoException("Exame não encontrado"));

        exameRepository.delete(exame);
    }
}
