package TuFixTu.FixtureArg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TuFixTu.FixtureArg.models.Partido;

@Repository
public interface IPartidoRepository extends JpaRepository<Partido, Long> {

    List<Partido> findByFechaIdId(Long fechaId);
    
}
