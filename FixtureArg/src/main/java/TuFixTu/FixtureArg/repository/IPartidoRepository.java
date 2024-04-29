package TuFixTu.FixtureArg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TuFixTu.FixtureArg.models.Partido;

@Repository
public interface IPartidoRepository extends JpaRepository<Partido, Long> {
    
}
