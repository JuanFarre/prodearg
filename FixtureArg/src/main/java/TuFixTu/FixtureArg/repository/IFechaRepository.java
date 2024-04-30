package TuFixTu.FixtureArg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TuFixTu.FixtureArg.models.Fecha;

@Repository
public interface IFechaRepository extends JpaRepository<Fecha, Long>{

    
}
