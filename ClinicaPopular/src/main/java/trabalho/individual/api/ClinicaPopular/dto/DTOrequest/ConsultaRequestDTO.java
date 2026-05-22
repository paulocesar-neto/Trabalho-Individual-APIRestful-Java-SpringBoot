package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusConsulta;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoConsulta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaRequestDTO {

    @NotBlank(message = "A descrição é obrigatória")
    @NotNull(message = "A descrição não pode ser nula")
    @Size(max = 255,message = "O máximo é de 255 caracteres")
    private String descricao;
    @NotNull (message = "O valor não pode ser nula")
    @DecimalMin(value="100.00",inclusive = true,message = "O Valor da consulta é a partir de R$100.00")
    private BigDecimal valor;
    @NotNull (message = "A data e hora não podem ser nulas")
    private LocalDateTime dataHoraConsulta;
    private TipoConsulta  tipoConsulta;
    private StatusConsulta statusConsulta;
    private List<Paciente> pacientes;
    private List<Medico> medicos;

    public ConsultaRequestDTO() {
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

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
