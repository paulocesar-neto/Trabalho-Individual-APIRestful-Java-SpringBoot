package trabalho.individual.api.ClinicaPopular.database.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "identificador único do Prontuario",example = "1")
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema(description = "Numero do prontuario de cada Paciente",example = "123456-7")
    private String numero;

    @Column(nullable = false)
    @Schema(description = "Prescrição da consulta")
    private String prescricao;

    @Column(length = 255)
    @Schema(description = "Histórico de alergias do paciente")
    private String alergia;

    @Column(length = 255)
    @Schema(description = "Medicamentos de uso do paciente ou medicamentos receitados")
    private String medicamento;

    @Column(name = "data_hora_atendimento", nullable = false)
    @Schema(description = "Data e hora da consulta realizada no dia",example = "2026-05-22T14:30:00")
    private LocalDateTime dataHoraAtendimento;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    @JsonBackReference(value = "paciente-prontuario")
    @Schema(description = "Paciente que pertence ao prontuário")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    @JsonBackReference(value = "medico-prontuario")
    @Schema(description = "Histórico do médico que atendeu ao Paciente usando o prontuário dele")
    private List<Medico> medico;

    public Prontuario() {
    }

    public Prontuario(Long id, String numero, String prescricao, String alergia, String medicamento, LocalDateTime dataHoraAtendimento, Paciente paciente, List<Medico> medico) {
        this.id = id;
        this.numero = numero;
        this.prescricao = prescricao;
        this.alergia = alergia;
        this.medicamento = medicamento;
        this.dataHoraAtendimento = dataHoraAtendimento;
        this.paciente = paciente;
        this.medico = medico;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(id, that.id)
                && Objects.equals(numero, that.numero)
                && Objects.equals(prescricao, that.prescricao)
                && Objects.equals(alergia, that.alergia)
                && Objects.equals(medicamento, that.medicamento)
                && Objects.equals(dataHoraAtendimento, that.dataHoraAtendimento)
                && Objects.equals(paciente, that.paciente)
                && Objects.equals(medico, that.medico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                numero,
                prescricao,
                alergia,
                medicamento,
                dataHoraAtendimento,
                paciente,
                medico);
    }
}
