package trabalho.individual.api.ClinicaPopular.database.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(nullable = false,length = 100)
    private String nome;
    @NotNull
    @NotBlank
    @Size(max = 11)
    @Column(nullable = false,length = 11,unique = true)
    private String cpf;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @NotNull
    @NotBlank
    @Size(max = 70)
    @Column(nullable = false,length = 70,unique = true)
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(nullable = false,length = 50,unique = true)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

//    @NotNull
//    @NotBlank
//    @Size(max = 50)
//    @OneToOne
//    @JoinColumn(name = "id_prontuario")
//    private Prontuario prontuario;

    public Paciente() {
    }

    public Paciente(String nome, String cpf,LocalDate dataNascimento, String email, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
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

//    public Prontuario getProntuario() {
//        return prontuario;
//    }
//
//    public void setProntuario(Prontuario prontuario) {
//        this.prontuario = prontuario;
//    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(nome, paciente.nome) && Objects.equals(cpf, paciente.cpf) && Objects.equals(dataNascimento, paciente.dataNascimento) && Objects.equals(email, paciente.email) && Objects.equals(telefone, paciente.telefone) && Objects.equals(endereco, paciente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNascimento, email, telefone, endereco);
    }
}
