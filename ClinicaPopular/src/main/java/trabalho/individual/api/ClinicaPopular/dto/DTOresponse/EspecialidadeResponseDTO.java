package trabalho.individual.api.ClinicaPopular.dto.DTOresponse;

import trabalho.individual.api.ClinicaPopular.database.domain.Especialidade;
import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoEspecialidade;

import java.util.List;

public class EspecialidadeResponseDTO {

    private Long id;
    private TipoEspecialidade tipoEspecialidade;
    private String descricao;
    private String codigoCBO;
    private List<Medico> medicos;

    public EspecialidadeResponseDTO() {
    }

    public EspecialidadeResponseDTO(Especialidade especialidade) {
        this.id = especialidade.getId();
        this.tipoEspecialidade = especialidade.getTipoEspecialidade();
        this.descricao =  especialidade.getDescricao() ;
        this.codigoCBO = especialidade.getCodigoCBO();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEspecialidade getTipoEspecialidade() {
        return tipoEspecialidade;
    }

    public void setTipoEspecialidade(TipoEspecialidade tipoEspecialidade) {
        this.tipoEspecialidade = tipoEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoCBO() {
        return codigoCBO;
    }

    public void setCodigoCBO(String codigoCBO) {
        this.codigoCBO = codigoCBO;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
