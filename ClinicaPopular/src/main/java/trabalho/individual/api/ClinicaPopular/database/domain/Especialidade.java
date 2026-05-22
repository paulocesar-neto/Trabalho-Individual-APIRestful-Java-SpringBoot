package trabalho.individual.api.ClinicaPopular.database.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoEspecialidade;
import java.util.Objects;

@Entity
@Table(name = "especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da consulta",example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Tipo de Especialidade do Médico",example="CARDIOLOGISTA")
    private TipoEspecialidade tipoEspecialidade;


    @Column(nullable = false)
    @Schema(description = "Descrição da especialidade")
    private String descricao;


    @Column(name = "codigo_cbo", nullable = false,length = 255)
    @Schema(description = "Codigo Brasileiro de Ocupação", example = "2251-25")
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
