package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusConsulta;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoConsulta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;

    public Consulta() {
    }

    public Consulta(Long id, String descricao, BigDecimal valor, LocalDate dataHoraConsulta, StatusConsulta status, TipoConsulta tipoConsulta) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataHoraConsulta = dataHoraConsulta;
        this.status = status;
        this.tipoConsulta = tipoConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDate dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id) && Objects.equals(descricao, consulta.descricao) && Objects.equals(valor, consulta.valor) && Objects.equals(dataHoraConsulta, consulta.dataHoraConsulta) && status == consulta.status && tipoConsulta == consulta.tipoConsulta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, dataHoraConsulta, status, tipoConsulta);
    }
}
