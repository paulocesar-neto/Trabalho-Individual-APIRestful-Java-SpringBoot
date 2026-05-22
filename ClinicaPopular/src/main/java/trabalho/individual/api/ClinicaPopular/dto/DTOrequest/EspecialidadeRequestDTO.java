package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoEspecialidade;

import java.util.List;

public class EspecialidadeRequestDTO {

   private TipoEspecialidade tipoEspecialidade;
   private String descricao;
   private String codigoCBO;
   private List<Medico> medicos;

    public EspecialidadeRequestDTO() {
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
