package trabalho.individual.api.ClinicaPopular.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.individual.api.ClinicaPopular.database.domain.Exame;
import trabalho.individual.api.ClinicaPopular.enumerated.TipoExames;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    Exame findBytipoExames(TipoExames tipoExames);
}
