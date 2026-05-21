package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal numero;
    private String anamnese;
    private LocalDate dataHoraAtendimento;
    private String queixa_principal;
    private String diagnostico;
    private String conduta;

    public Prontuario() {
    }

    public Prontuario(Long id,BigDecimal numero, String anamnese, LocalDate dataHoraAtendimento, String queixa_principal, String diagnostico, String conduta) {
        this.id = id;
        this.anamnese = anamnese;
        this.dataHoraAtendimento = dataHoraAtendimento;
        this.queixa_principal = queixa_principal;
        this.diagnostico = diagnostico;
        this.conduta = conduta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public LocalDate getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }

    public void setDataHoraAtendimento(LocalDate dataHoraAtendimento) {
        this.dataHoraAtendimento = dataHoraAtendimento;
    }

    public String getQueixa_principal() {
        return queixa_principal;
    }

    public void setQueixa_principal(String queixa_principal) {
        this.queixa_principal = queixa_principal;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        diagnostico = diagnostico;
    }

    public String getConduta() {
        return conduta;
    }

    public void setConduta(String conduta) {
        this.conduta = conduta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(id, that.id) && Objects.equals(numero, that.numero) && Objects.equals(anamnese, that.anamnese) && Objects.equals(dataHoraAtendimento, that.dataHoraAtendimento) && Objects.equals(queixa_principal, that.queixa_principal) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(conduta, that.conduta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, anamnese, dataHoraAtendimento, queixa_principal, diagnostico, conduta);
    }
}
