package trabalho.individual.api.ClinicaPopular.dto.DTOresponse;

import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.database.domain.Paciente;
import trabalho.individual.api.ClinicaPopular.database.domain.Prontuario;

import java.time.LocalDateTime;
import java.util.List;

public class ProntuarioResponseDTO{

    private Long id;
    private String numero;
    private String prescricao;
    private String alergia;
    private String medicamento;
    private LocalDateTime dataHoraAtendimento;
    private Paciente paciente;
    private List<Medico> medico;

    public ProntuarioResponseDTO() {
    }

    public ProntuarioResponseDTO(Prontuario prontuario) {
        this.id = prontuario.getId();
        this.numero = prontuario.getNumero();
        this.prescricao = prontuario.getPrescricao();
        this.alergia = prontuario.getAlergia();
        this.medicamento = prontuario.getMedicamento();
        this.dataHoraAtendimento = prontuario.getDataHoraAtendimento();
        this.paciente = prontuario.getPaciente();
        this.medico = prontuario.getMedico();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Medico> getMedico() {
        return medico;
    }

    public void setMedico(List<Medico> medico) {
        this.medico = medico;
    }

}
