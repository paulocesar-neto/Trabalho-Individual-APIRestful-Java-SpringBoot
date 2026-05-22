package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoEspecialidade;

import java.util.List;

public class EspecialidadeRequestDTO {


   @NotNull(message = "O Tipo de especialidade não pode ser nulo")
   private TipoEspecialidade tipoEspecialidade;
   @NotBlank(message = "A descrição deve ser preenchida")
   @NotNull (message = "A descrição não pode ser nula")
   private String descricao;
   @NotBlank(message = "O Código CFM é obrigatório")
   @NotNull(message = "O Código CFM não pode ser nulo")
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
