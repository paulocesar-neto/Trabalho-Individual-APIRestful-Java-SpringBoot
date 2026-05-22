package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusExame;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoExames;

public class ExameRequestDTO {

    private TipoExames exames;
    private StatusExame status;
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
