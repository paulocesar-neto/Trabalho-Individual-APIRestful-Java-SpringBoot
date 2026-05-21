package trabalho.individual.api.ClinicaPopular.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import trabalho.individual.api.ClinicaPopular.database.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Consulta findById(long id);
}
