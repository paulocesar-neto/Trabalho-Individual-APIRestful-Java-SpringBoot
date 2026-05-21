package trabalho.individual.api.ClinicaPopular.database.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do Médico é obrigatório")
    @NotNull(message = "O nome do Médico não pode ser nulo")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O nome do Médico é obrigatório")
    @NotNull(message = "O nome do Médico não pode ser nulo")
    @Size(min = 14, max = 14, message = "O CFP deve conter 14 dígitos")
    @CPF(message = "Formato inválido,preencha corretamente.exemplo: 123.456.789-10")
    @Column(nullable = false,length = 14,unique = true)
    private String cpf;

    @NotBlank(message = "O CRM é obrigatório")
    @NotNull(message = "O CRM não pode ser nulo")
    @Size(max = 15,message = "O CRM deve possuir no máximo 15 caracteres")
    @Column(nullable = false,length = 15,unique = true)
    private String crm;

    @NotBlank(message = "O telefone é obrigatório")
    @NotNull(message = "O telefone não pode ser nulo")
    @Column(nullable = false,unique = true)
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @NotNull(message = "Email não pode ser nulo")
    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consulta;

    @OneToMany
    @JoinColumn(name = "id_paciente")
    private List<Paciente> paciente;

    @OneToMany (mappedBy = "medico")
    private List<Prontuario> prontuario;


    @ManyToMany
    @JoinTable(name = "medico_especialidade",
    joinColumns = @JoinColumn (name = "id_medico"),
    inverseJoinColumns = @JoinColumn(name="id_especialidade"))
    private List<Especialidade> especialidade;


    public Medico() {
    }

    public Medico(Long id, String nome, String cpf, String crm, String telefone, String email, List<Consulta> consulta, List<Paciente> paciente, List<Prontuario> prontuario, List<Especialidade> especialidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.telefone = telefone;
        this.email = email;
        this.consulta = consulta;
        this.paciente = paciente;
        this.prontuario = prontuario;
        this.especialidade = especialidade;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }

    public List<Especialidade> getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List<Especialidade> especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id)
                && Objects.equals(nome, medico.nome)
                && Objects.equals(cpf, medico.cpf)
                && Objects.equals(crm, medico.crm)
                && Objects.equals(telefone, medico.telefone)
                && Objects.equals(email, medico.email)
                && Objects.equals(consulta, medico.consulta)
                && Objects.equals(paciente, medico.paciente)
                && Objects.equals(prontuario, medico.prontuario)
                && Objects.equals(especialidade, medico.especialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                nome,
                cpf,
                crm,
                telefone,
                email,
                consulta,
                paciente,
                prontuario,
                especialidade);
    }
}
