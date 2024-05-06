package TuFixTu.FixtureArg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TuFixTu.FixtureArg.models.Pronostico;

@Repository
public interface IPronosticoRepository extends JpaRepository<Pronostico, Long> {
    
}
