package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusExame;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoExames;

import java.util.Objects;

@Entity
@Table(name = "exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O tipo do exame deve ser preenchido")
    @NotNull(message = "O tipo do exame não pode ser nulo")
    @Enumerated(EnumType.ORDINAL)
    private TipoExames exames;

    @Enumerated(EnumType.ORDINAL)
    private StatusExame status;

    @NotBlank(message = "o motivo deve ser preenchido")
    @NotNull (message = "O motivo não pode ser nulo")
    @Column(nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public Exame() {
    }

    public Exame(Long id, TipoExames exames, StatusExame status, String motivo, Paciente paciente) {
        this.id = id;
        this.exames = exames;
        this.status = status;
        this.motivo = motivo;
        this.paciente = paciente;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exame exame = (Exame) o;
        return Objects.equals(id, exame.id)
                && exames == exame.exames
                && status == exame.status
                && Objects.equals(motivo, exame.motivo)
                && Objects.equals(paciente, exame.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exames, status, motivo, paciente);
    }


}
