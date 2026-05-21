package trabalho.individual.api.ClinicaPopular.database.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal numero;
    private String prescricao;
    private String alergia;
    private String medicamento;
    private LocalDateTime dataHoraAtendimento;


    private Paciente paciente;

    private Medico medico;


    public Prontuario() {
    }


}
