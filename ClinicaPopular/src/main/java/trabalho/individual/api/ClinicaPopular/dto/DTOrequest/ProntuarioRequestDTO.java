package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;


import java.time.LocalDateTime;

public class ProntuarioRequestDTO {

    @NotNull(message = "numero do prontuário não pode ser nulo")
    @NotBlank(message = "Número do prontuário é obrigatório")
    private String numero;

    @NotNull(message = "Precrição não pode ser nula")
    @NotBlank(message = "Prescrição é obrigatória")
    private String prescricao;

    @NotNull(message = "Alergia não pode ser nula")
    @NotBlank(message = "Alergia é obrigatória")
    @Size(max = 255)
    private String alergia;

    @Size(max = 255)
    private String medicamento;
    @NotNull(message = "Data e Hora é obrigatório")
    private LocalDateTime dataHoraAtendimento;

    private Paciente paciente;

    public ProntuarioRequestDTO() {
    }

    public String getNumero() {
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
