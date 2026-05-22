package trabalho.individual.api.ClinicaPopular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.individual.api.ClinicaPopular.database.domain.Consulta;
import trabalho.individual.api.ClinicaPopular.database.repository.ConsultaRepository;
import trabalho.individual.api.ClinicaPopular.dto.DTOrequest.ConsultaRequestDTO;
import trabalho.individual.api.ClinicaPopular.dto.DTOresponse.ConsultaResponseDTO;
import trabalho.individual.api.ClinicaPopular.exception.RecursoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ConsultaResponseDTO> listarConsultas() {
        List<Consulta> consultas = consultaRepository.findAll();
        List<ConsultaResponseDTO> consultaDTO = new ArrayList<ConsultaResponseDTO>();

        for (Consulta consulta : consultas){
            consultaDTO.add(new ConsultaResponseDTO(consulta));
        }
        return  consultaDTO;
    }

    public ConsultaResponseDTO buscarConsultaID(Long id){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Especialidade não Encontrada"));

        return new ConsultaResponseDTO(consulta);
    }


    public ConsultaResponseDTO inserir (ConsultaRequestDTO consultaDTO){


        Consulta consulta = new Consulta();

        consulta.setDescricao(consultaDTO.getDescricao());
        consulta.setDataHoraConsulta(consultaDTO.getDataHoraConsulta());
        consulta.setValor(consultaDTO.getValor());
        consulta.setStatus(consultaDTO.getStatusConsulta());
        consulta.setTipoConsulta(consultaDTO.getTipoConsulta());

        consulta = consultaRepository.save(consulta);

        return new ConsultaResponseDTO(consulta);
    }

    public ConsultaResponseDTO atualizar (ConsultaRequestDTO consultaDTO, Long id){

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Especialidade Não Encontrada"));

        consulta.setDescricao(consultaDTO.getDescricao());
        consulta.setDataHoraConsulta(consultaDTO.getDataHoraConsulta());
        consulta.setValor(consultaDTO.getValor());
        consulta.setStatus(consultaDTO.getStatusConsulta());
        consulta.setTipoConsulta(consultaDTO.getTipoConsulta());



        consulta = consultaRepository.save(consulta);
        return new ConsultaResponseDTO(consulta);

    }

    public void remover (Long id){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() ->new RecursoNaoEncontradoException("Exame não encontrado"));

        consultaRepository.delete(consulta);
    }

}
