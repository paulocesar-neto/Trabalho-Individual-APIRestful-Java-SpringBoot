package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProntuarioRequestDTO {

    private String numero;
    private String prescricao;
    private String alergia;
    private String medicamento;
    private LocalDateTime dataHoraAtendimento;
    private Paciente paciente;

    public ProntuarioRequestDTO() {
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public LocalDateTime getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }

    public void setDataHoraAtendimento(LocalDateTime dataHoraAtendimento) {
        this.dataHoraAtendimento = dataHoraAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
