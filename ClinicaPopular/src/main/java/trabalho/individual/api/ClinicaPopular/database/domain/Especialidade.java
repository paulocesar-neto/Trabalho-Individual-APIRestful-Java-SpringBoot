package trabalho.individual.api.ClinicaPopular.database.domain;


import jakarta.persistence.*;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoEspecialidade;

import java.util.Objects;

@Entity
@Table(name = "especialidade")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoEspecialidade tipoEspecialidade;

    private String codigoCFM;

    public Especialidade() {
    }

    public Especialidade(Long id, TipoEspecialidade tipoEspecialidade, String codigoCFM) {
        this.id = id;
        this.tipoEspecialidade = tipoEspecialidade;
        this.codigoCFM = codigoCFM;
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

    public String getCodigoCFM() {
        return codigoCFM;
    }

    public void setCodigoCFM(String codigoCFM) {
        this.codigoCFM = codigoCFM;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Especialidade that = (Especialidade) o;
        return Objects.equals(id, that.id) && tipoEspecialidade == that.tipoEspecialidade && Objects.equals(codigoCFM, that.codigoCFM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoEspecialidade, codigoCFM);
    }
}
