package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório.Por favor preencha!")
    @NotBlank(message = "O nome é obrigatório.Por favor preencha! ")
    @Size(max = 100, message = "O maximo é de 100 caracteres")
    @Column(nullable = false,length = 100)
    private String nome;

    @NotNull(message = "CPF é obrigatório.Por favor preencha!")
    @NotBlank(message = "CPF é obrigatório.Por favor preencha!")
    @Size(max = 11,message = "O máximo é de 11 caracteres")
    @Column(nullable = false,length = 11,unique = true)
    private String cpf;

    @NotNull(message ="Data de Nascimento é obrigatória.Por Favor preencha!" )
    @NotBlank(message ="Data de Nascimento é obrigatória.Por Favor preencha!" )
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotNull(message ="O Email é obrigatório.Por Favor preencha!" )
    @NotBlank(message ="O Email é obrigatório.Por Favor preencha!" )
    @Email(message = "O email tem que estar no formato email. Exemplo: email@example.com")
    @Size(max = 70)
    @Column(nullable = false,length = 70,unique = true)
    private String email;

    @NotNull(message = "O Telefone é obrigatório.Por favor preencha!")
    @NotBlank(message = "O Telefone é obrigatório.Por favor preencha!")
    @Size(max = 11,message = "O numero de telefone é no máximo 11 caracteres. Exemplo: DD 9XXXX-XXXX")
    @Column(nullable = false,length = 11,unique = true)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @OneToOne
    @JoinColumn(name = "id_prontuario")
    private Prontuario prontuario;

    @OneToMany(mappedBy="paciente")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente")
    private List<Exame> exame;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String cpf, LocalDate dataNascimento,
    String email, String telefone, String endereco, Prontuario prontuario, List<Consulta> consultas,
    List<Exame> exame) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
                && Objects.equals(endereco, paciente.endereco)
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
                endereco,
                prontuario,
                consultas,
                exame);
    }
}
