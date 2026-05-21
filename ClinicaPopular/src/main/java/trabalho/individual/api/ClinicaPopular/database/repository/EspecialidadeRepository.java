package trabalho.individual.api.ClinicaPopular.database.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.individual.api.ClinicaPopular.database.domain.Especialidade;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoEspecialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    Especialidade findBytipoEspecialidade(TipoEspecialidade tipoEspecialidade);
}
