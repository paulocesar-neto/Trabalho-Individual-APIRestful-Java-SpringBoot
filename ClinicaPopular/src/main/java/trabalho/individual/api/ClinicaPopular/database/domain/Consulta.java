package trabalho.individual.api.ClinicaPopular.database.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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
    @Schema(description = "Identificador único da consulta",example = "1")
    private Long id;

    @Column(nullable = false,length = 255)
    @Schema(description = "Descrição da consulta", example = "Consulta de rotina")
    private String descricao;


    @Column(nullable = false)
    @Schema(description = "Valor da consulta", example = "150.00")
    private BigDecimal valor;


    @Column(name = "data_hora_consulta", nullable = false)
    @Schema(description = "Data e hora da consulta",example = "2026-05-22T14:30:00")
    private LocalDateTime dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Status atual da consulta",example = "AGENDADA")
    private StatusConsulta status;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Tipo da consulta",example = "AGENDADA")
    private TipoConsulta tipoConsulta;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    @JsonBackReference(value = "paciente-consulta")
    @Schema(description = "Paciente vinculado à consulta")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    @JsonBackReference(value = "medico-consulta")
    @Schema(description = "Médico responsável pela consulta")
    private Medico medico;

    public Consulta() {
    }

    public Consulta(Long id, String descricao, BigDecimal valor, LocalDateTime dataHoraConsulta, StatusConsulta status, TipoConsulta tipoConsulta, Paciente paciente, Medico medico) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataHoraConsulta = dataHoraConsulta;
        this.status = status;
        this.tipoConsulta = tipoConsulta;
        this.paciente = paciente;
        this.medico = medico;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id)
                && Objects.equals(descricao, consulta.descricao)
                && Objects.equals(valor, consulta.valor)
                && Objects.equals(dataHoraConsulta, consulta.dataHoraConsulta)
                && status == consulta.status && tipoConsulta == consulta.tipoConsulta
                && Objects.equals(paciente, consulta.paciente)
                && Objects.equals(medico, consulta.medico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                descricao,
                valor,
                dataHoraConsulta,
                status,
                tipoConsulta,
                paciente,
                medico);
    }
}
