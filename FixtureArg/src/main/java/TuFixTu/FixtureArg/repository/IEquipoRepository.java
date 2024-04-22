package TuFixTu.FixtureArg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TuFixTu.FixtureArg.models.Equipo;

@Repository
public interface IEquipoRepository extends JpaRepository<Equipo, Long> {

    
    
}
