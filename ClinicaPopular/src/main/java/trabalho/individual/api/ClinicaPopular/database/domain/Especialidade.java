package trabalho.individual.api.ClinicaPopular.database.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "especialidade")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String especialidade;
    private String codigoCFM;

    public Especialidade() {
    }

    public Especialidade(int id, String especialidade, String codigoCFM) {
        this.id = id;
        this.especialidade = especialidade;
        this.codigoCFM = codigoCFM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == that.id && Objects.equals(especialidade, that.especialidade) && Objects.equals(codigoCFM, that.codigoCFM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, especialidade, codigoCFM);
    }
}
