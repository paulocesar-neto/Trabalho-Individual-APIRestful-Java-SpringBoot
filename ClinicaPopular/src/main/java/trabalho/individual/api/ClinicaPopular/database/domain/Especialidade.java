package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoEspecialidade;

import java.util.Objects;

@Entity
@Table(name = "especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Tipo de especialidade deve ser preenchido")
    @NotNull (message = "O Tipo de especialidade não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private TipoEspecialidade tipoEspecialidade;

    @NotBlank(message = "A descrição deve ser preenchida")
    @NotNull (message = "A descrição não pode ser nula")
    @Column(nullable = false)
    private String descricao;

    @NotBlank(message = "O Código CFM é obrigatório")
    @NotNull(message = "O Código CFM não pode ser nulo")
    @Column(name = "codigo_cbo", nullable = false,length = 255)
    private String codigoCBO;//Código Brasileito de Ocupação;

    public Especialidade() {
    }

    public Especialidade(Long id, TipoEspecialidade tipoEspecialidade, String descricao, String codigoCBO) {
        this.id = id;
        this.tipoEspecialidade = tipoEspecialidade;
        this.descricao = descricao;
        this.codigoCBO = codigoCBO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEspecialidade getTipoEspecialidade() {
        return tipoEspecialidade;
    }

    public void setTipoEspecialidade(TipoEspecialidade tipoEspecialidade) {
        this.tipoEspecialidade = tipoEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoCBO() {
        return codigoCBO;
    }

    public void setCodigoCBO(String codigoCBO) {
        this.codigoCBO = codigoCBO;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Especialidade that = (Especialidade) o;
        return Objects.equals(id, that.id)
                && tipoEspecialidade == that.tipoEspecialidade
                && Objects.equals(descricao, that.descricao)
                && Objects.equals(codigoCBO, that.codigoCBO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                tipoEspecialidade,
                descricao,
                codigoCBO);
    }
}
