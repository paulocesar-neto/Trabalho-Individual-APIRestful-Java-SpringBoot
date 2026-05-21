package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;

import trabalho.individual.api.ClinicaPopular.enumerated.StatusExame;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoExames;

import java.util.Objects;

@Entity
@Table(name = "exame")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private TipoExames exames;

    @Enumerated(EnumType.ORDINAL)
    private StatusExame status;

    private String motivo;

    public Exame() {
    }

    public Exame(Long id, TipoExames exames, StatusExame status, String motivo) {
        this.id = id;
        this.exames = exames;
        this.status = status;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exame exame = (Exame) o;
        return Objects.equals(id, exame.id)
                && exames == exame.exames
                && status == exame.status
                && Objects.equals(motivo, exame.motivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exames, status, motivo);
    }
}
