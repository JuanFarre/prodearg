package TuFixTu.FixtureArg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TuFixTu.FixtureArg.models.Pronostico;

import java.util.List;

@Repository
public interface IPronosticoRepository extends JpaRepository<Pronostico, Long> {

    List<Pronostico> findByUsuarioIdAndPartidoFechaIdId(Long usuarioId, Long fechaId);
}
