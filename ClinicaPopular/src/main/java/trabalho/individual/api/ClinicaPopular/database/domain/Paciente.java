package trabalho.individual.api.ClinicaPopular.database.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "identificador único do Paciente",example = "1")
    private Long id;

    @Column(nullable = false,length = 100)
    @Schema(description = "Nome Completo do Paciente")
    private String nome;

    @Column(nullable = false,length = 14,unique = true)
    @Schema(description = "CPF formatado do cliente",example = "123.456.789-10")
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    @Schema(description = "Data de Nascimento do Paciente",example = "0000-00-00")
    private LocalDate dataNascimento;

    @Column(nullable = false,unique = true)
    @Schema(description = "Email do paciente")
    private String email;

    @Column(nullable = false,unique = true)
    @Schema(description = "Telefone do Paciente")
    private String telefone;

    @OneToOne(mappedBy = "paciente")
    @Schema(description = "Prontuário do Paciente")
    @JsonManagedReference(value = "paciente-prontuario")
    private Prontuario prontuario;

    @OneToMany(mappedBy="paciente")
    @JsonManagedReference(value = "paciente-consulta")
    @Schema(description = "Consultas que o paciente realizou")
    private List<Consulta> consultas;

    @OneToMany(mappedBy ="paciente")
    @JsonManagedReference(value = "paciente-exame")
    @Schema(description = "Exames que o Paciente realizou")
    private List<Exame> exame;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String cpf, LocalDate dataNascimento, String email, String telefone, Prontuario prontuario, List<Consulta> consultas, List<Exame> exame) {
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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
