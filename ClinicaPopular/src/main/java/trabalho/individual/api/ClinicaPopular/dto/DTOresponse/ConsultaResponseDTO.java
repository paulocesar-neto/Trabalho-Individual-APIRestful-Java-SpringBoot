package trabalho.individual.api.ClinicaPopular.dto.DTOresponse;

import trabalho.individual.api.ClinicaPopular.database.domain.Consulta;
import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.enumerated.StatusConsulta;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoConsulta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaResponseDTO {

    private String descricao;
    private LocalDateTime dataHoraConsulta;
    private BigDecimal valor;
    private StatusConsulta statusConsulta;
    private TipoConsulta tipoConsulta;
    private List<Paciente> paciente;
    private List<Medico> medico;

    public ConsultaResponseDTO(Consulta consulta) {
        this.descricao = consulta.getDescricao();
        this.dataHoraConsulta = consulta.getDataHoraConsulta();
        this.valor = consulta.getValor();
        this.statusConsulta = consulta.getStatus();
        this.tipoConsulta = consulta.getTipoConsulta();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

    public List<Medico> getMedico() {
        return medico;
    }

    public void setMedico(List<Medico> medico) {
        this.medico = medico;
    }
}
