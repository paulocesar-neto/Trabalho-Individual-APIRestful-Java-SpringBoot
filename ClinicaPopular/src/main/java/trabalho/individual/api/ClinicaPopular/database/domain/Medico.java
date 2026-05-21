package trabalho.individual.api.ClinicaPopular.database.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String crm;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;

    public Medico() {
    }

    public Medico(Long id, String nome, String cpf, String crm, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.telefone = telefone;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id) && Objects.equals(nome, medico.nome) && Objects.equals(cpf, medico.cpf) && Objects.equals(crm, medico.crm) && Objects.equals(telefone, medico.telefone) && Objects.equals(email, medico.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, crm, telefone, email);
    }
}
