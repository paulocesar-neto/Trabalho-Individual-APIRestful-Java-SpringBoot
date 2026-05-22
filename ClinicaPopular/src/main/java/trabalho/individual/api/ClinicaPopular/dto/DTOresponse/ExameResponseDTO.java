package trabalho.individual.api.ClinicaPopular.dto.DTOresponse;

import trabalho.individual.api.ClinicaPopular.database.domain.Exame;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusExame;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoExames;

public class ExameResponseDTO {

    private Long id;
    private TipoExames tipoExame;
    private StatusExame status;
    private String motivo;
    private Paciente paciente;

    public ExameResponseDTO() {
    }

    public ExameResponseDTO(Exame exame) {
        this.id = exame.getId();
        this.tipoExame = exame.getExames();
        this.status = exame.getStatus();
        this.motivo = exame.getMotivo();
        this.paciente = exame.getPaciente();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoExames getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExames tipoExame) {
        this.tipoExame = tipoExame;
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
