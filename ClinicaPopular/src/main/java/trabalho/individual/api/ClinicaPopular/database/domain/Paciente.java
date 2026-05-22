package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String nome;

    @Column(nullable = false,length = 14,unique = true)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDateTime dataNascimento;

    @Column(nullable = false,unique = true)
    private String email;


    @Column(nullable = false,unique = true)
    private String telefone;

    @OneToOne(mappedBy = "paciente")
    private Prontuario prontuario;

    @OneToMany(mappedBy="paciente")
    private List<Consulta> consultas;

    @OneToMany(mappedBy ="paciente")
    private List<Exame> exame;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String cpf, LocalDateTime dataNascimento, String email, String telefone, Prontuario prontuario, List<Consulta> consultas, List<Exame> exame) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.prontuario = prontuario;
        this.consultas = consultas;
        this.exame = exame;
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

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id)
                && Objects.equals(nome, paciente.nome)
                && Objects.equals(cpf, paciente.cpf)
                && Objects.equals(dataNascimento, paciente.dataNascimento)
                && Objects.equals(email, paciente.email)
                && Objects.equals(telefone, paciente.telefone)
                && Objects.equals(prontuario, paciente.prontuario)
                && Objects.equals(consultas, paciente.consultas)
                && Objects.equals(exame, paciente.exame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                nome,
                cpf,
                dataNascimento,
                email,
                telefone,
                prontuario,
                consultas,
                exame);
    }
}
