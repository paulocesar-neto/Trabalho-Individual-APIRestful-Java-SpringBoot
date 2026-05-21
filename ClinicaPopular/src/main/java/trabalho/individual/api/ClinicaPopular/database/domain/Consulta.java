package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusConsulta;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoConsulta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    @NotNull (message = "A descrição não pode ser nula")
    @Size(max = 255,message = "O máximo é de 255 caracteres")
    @Column(nullable = false,length = 255)
    private String descricao;

    @NotBlank(message = "O valor é obrigatória")
    @NotNull (message = "O valor não pode ser nula")
    @DecimalMin(value="100.00",inclusive = true,message = "O Valor da consulta é a partir de R$100.00")
    @Column(nullable = false)
    private BigDecimal valor;

    @NotBlank(message = "A data e hora são  obrigatórias")
    @NotNull (message = "A data e hora não podem ser nulas")
    @Column(nullable = false)
    private LocalDateTime dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;

    public Consulta() {
    }

    public Consulta(Long id, String descricao, BigDecimal valor, LocalDateTime dataHoraConsulta, StatusConsulta status, TipoConsulta tipoConsulta) {
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

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
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
