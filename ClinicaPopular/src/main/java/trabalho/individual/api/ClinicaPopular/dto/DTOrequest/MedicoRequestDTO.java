package trabalho.individual.api.ClinicaPopular.dto.DTOrequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import trabalho.individual.api.ClinicaPopular.database.domain.Consulta;
import trabalho.individual.api.ClinicaPopular.database.domain.Especialidade;
import trabalho.individual.api.ClinicaPopular.database.domain.Prontuario;

import java.util.List;

public class MedicoRequestDTO {

    @NotBlank(message = "O nome do Médico é obrigatório")
    @NotNull(message = "O nome do Médico não pode ser nulo")
    private String nome;

    @NotBlank(message = "O CRM é obrigatório")
    @NotNull(message = "O CRM não pode ser nulo")
    @Size(max = 15,message = "O CRM deve possuir no máximo 15 caracteres")
    private String crm;

    @NotBlank(message = "O telefone é obrigatório")
    @NotNull(message = "O telefone não pode ser nulo")
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @NotNull(message = "Email não pode ser nulo")
    private String email;

    private List<Especialidade> especialidades;
    private List<Consulta> consultas;
    private List<Prontuario> prontuario;

    public MedicoRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }
}
