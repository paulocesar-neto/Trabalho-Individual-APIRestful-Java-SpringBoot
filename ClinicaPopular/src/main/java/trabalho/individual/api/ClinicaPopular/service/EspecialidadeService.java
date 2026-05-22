package trabalho.individual.api.ClinicaPopular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.individual.api.ClinicaPopular.database.domain.Especialidade;
import trabalho.individual.api.ClinicaPopular.database.repository.EspecialidadeRepository;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.EspecialidadeRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.EspecialidadeResponseDTO;
import trabalho.individual.api.ClinicaPopular.exception.RecursoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<EspecialidadeResponseDTO> listarEspecialidades(){
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        List<EspecialidadeResponseDTO> especialidadesDTO = new ArrayList<EspecialidadeResponseDTO>();

        for (Especialidade especialidade:especialidades){
            especialidadesDTO.add(new EspecialidadeResponseDTO(especialidade));
        }
        return  especialidadesDTO;
    }

    public EspecialidadeResponseDTO buscarEspecialidadeID(Long id){
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Especialidade não Encontrada"));

        return new EspecialidadeResponseDTO(especialidade);
    }


    public EspecialidadeResponseDTO inserirEspecialidade (EspecialidadeRequestDTO especialidadeDTO){


        Especialidade especialidade = new Especialidade();

        especialidade.setTipoEspecialidade(especialidadeDTO.getTipoEspecialidade());
        especialidade.setDescricao(especialidadeDTO.getDescricao());
        especialidade.setCodigoCBO(especialidadeDTO.getCodigoCBO());



        especialidade = especialidadeRepository.save(especialidade);

        return new EspecialidadeResponseDTO(especialidade);
    }

    public EspecialidadeResponseDTO atualizarEspecialidade (EspecialidadeRequestDTO especialidadeDTO, Long id){

        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Especialidade Não Encontrada"));

        especialidade.setTipoEspecialidade(especialidadeDTO.getTipoEspecialidade());
        especialidade.setDescricao(especialidadeDTO.getDescricao());
        especialidade.setCodigoCBO(especialidadeDTO.getCodigoCBO());


        especialidade = especialidadeRepository.save(especialidade);
        return new EspecialidadeResponseDTO(especialidade);

    }

    public void removerEspecialidade (Long id){
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() ->new RecursoNaoEncontradoException("Especialidade não encontrado"));

        especialidadeRepository.delete(especialidade);
    }

}
