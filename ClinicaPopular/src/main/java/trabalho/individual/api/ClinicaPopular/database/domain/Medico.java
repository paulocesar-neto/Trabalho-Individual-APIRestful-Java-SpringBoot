package trabalho.individual.api.ClinicaPopular.database.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "identificador único do Médico",example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nome completo do médico")
    private String nome;

    @Column(nullable = false,length = 15,unique = true)
    @Schema(description = "CRM do médico",example = "CRM/RJ 123456")
    private String crm;

    @Column(nullable = false,unique = true)
    @Schema(description = "Telefone Celular do médico")
    private String telefone;

    @Column(nullable = false,unique = true)
    @Schema(description = "Email do médico")
    private String email;

    @OneToMany(mappedBy = "medico")
    @JsonManagedReference(value = "medico-consulta")
    @Schema(description = "Consultas realizadas pelos médicos")
    private List<Consulta> consulta;

    @OneToMany (mappedBy = "medico")
    @JsonManagedReference(value = "medico-prontuario")
    @Schema(description = "Prontuário atendido pelos médicos")
    private List<Prontuario> prontuario;

    @ManyToMany
    @JoinTable(name = "medico_especialidade",
    joinColumns = @JoinColumn (name = "id_medico"),
    inverseJoinColumns = @JoinColumn(name="id_especialidade"))
    @Schema(description = "Especialidade do Médico")
    private List<Especialidade> especialidade;

    public Medico() {
    }

    public Medico(Long id, String nome, String crm, String telefone, String email, List<Consulta> consulta, List<Prontuario> prontuario, List<Especialidade> especialidade) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
        this.email = email;
        this.consulta = consulta;

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
                && Objects.equals(crm, medico.crm)
                && Objects.equals(telefone, medico.telefone)
                && Objects.equals(email, medico.email)
                && Objects.equals(consulta, medico.consulta)
                && Objects.equals(prontuario, medico.prontuario)
                && Objects.equals(especialidade, medico.especialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                nome,
                crm,
                telefone,
                email,
                consulta,
                prontuario,
                especialidade);
    }
}
