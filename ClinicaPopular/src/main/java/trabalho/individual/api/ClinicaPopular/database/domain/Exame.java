package trabalho.individual.api.ClinicaPopular.database.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusExame;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoExames;
import java.util.Objects;

@Entity
@Table(name = "exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "identificador único do Exame",example = "1")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Schema(description = "Tipos de Exames",example = "Raio x")
    private TipoExames exames;

    @Enumerated(EnumType.ORDINAL)
    @Schema(description = "Status do Exame",example = "AGENDADO")
    private StatusExame status;

    @Column(nullable = false)
    @Schema(description = "Motivo do exame para que foi pedido")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    @JsonBackReference(value = "paciente-exame")
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
