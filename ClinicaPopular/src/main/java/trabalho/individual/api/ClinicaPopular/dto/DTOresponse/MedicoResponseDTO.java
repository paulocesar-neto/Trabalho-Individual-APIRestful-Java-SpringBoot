package trabalho.individual.api.ClinicaPopular.dto.DTOresponse;

import trabalho.individual.api.ClinicaPopular.database.domain.Consulta;
import trabalho.individual.api.ClinicaPopular.database.domain.Especialidade;
import trabalho.individual.api.ClinicaPopular.database.domain.Medico;
import trabalho.individual.api.ClinicaPopular.database.domain.Prontuario;

import java.util.List;

public class MedicoResponseDTO {

    private Long id;
    private String nome;
    private String crm;
    private String telefone;
    private String email;
    private List<Consulta> consultas;
    private List<Prontuario> prontuario;
    private List<Especialidade>  especialidades;


    public MedicoResponseDTO() {
    }

    public MedicoResponseDTO(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.telefone = medico.getTelefone();
        this.email = medico.getEmail();
        this.consultas = medico.getConsulta();
        this.prontuario =medico.getProntuario();
        this.especialidades = medico.getEspecialidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

}
