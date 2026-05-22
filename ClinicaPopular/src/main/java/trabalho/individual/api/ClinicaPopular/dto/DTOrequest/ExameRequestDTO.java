package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusExame;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoExames;

public class ExameRequestDTO {

    @NotNull(message = "O tipo do exame é obrigatório")
    private TipoExames exames;
    @NotNull(message = "O status do exame é obrigatório")
    private StatusExame status;
    @NotBlank(message = "o motivo deve ser preenchido")
    @NotNull (message = "O motivo não pode ser nulo")
    private String motivo;

    private Paciente paciente;

    public ExameRequestDTO() {
    }

    public TipoExames getExames() {
        return exames;
    }

    public void setExames(TipoExames exames) {
        this.exames = exames;
    }

    public StatusExame getStatus() {
        return status;
    }

    public void setStatus(StatusExame status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
