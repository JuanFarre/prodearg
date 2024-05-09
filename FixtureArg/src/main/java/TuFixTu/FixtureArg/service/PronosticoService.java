package TuFixTu.FixtureArg.service;

import java.util.List;

import TuFixTu.FixtureArg.models.Usuario;
import TuFixTu.FixtureArg.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TuFixTu.FixtureArg.models.Pronostico;
import TuFixTu.FixtureArg.repository.IPronosticoRepository;

@Service
public class PronosticoService implements IPronosticoService {
    @Autowired
    private IPronosticoRepository pronosticoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Pronostico> getListPronosticos() {
        return pronosticoRepository.findAll();
    }

    @Override
    public Pronostico getPronostico(Long id) {
        return pronosticoRepository.findById(id).orElse(null);
    }

    @Override
    public String deletePronostico(Long id) {
        pronosticoRepository.deleteById(id);
        return "Pronostico borrado";
    }

    @Override
    public Pronostico savePronostico(Pronostico pronostico) {
        return pronosticoRepository.save(pronostico);
    }

    @Override
    public Pronostico editPronostico(Long id, Pronostico pronostico) {
        Pronostico pronosticoExistente = pronosticoRepository.findById(id).orElse(null);

        if (pronosticoExistente != null) {

            pronosticoExistente.setUsuario(pronostico.getUsuario());
            pronosticoExistente.setPartido(pronostico.getPartido());
            pronosticoExistente.setGanaLocal(pronostico.isGanaLocal());
            pronosticoExistente.setGanaVisitante(pronostico.isGanaVisitante());

            return pronosticoRepository.save(pronosticoExistente);
        }

        return null;
    }

    @Override
    public int calcularPuntosByIdUsuario(Long id) {
        int puntuacion = 0;
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        for (Pronostico pronostico : usuario.getPronosticos()) {
            if (pronostico.isGanaLocal() == pronostico.getPartido().isGanaLocal() &&
                    pronostico.isGanaVisitante() == pronostico.getPartido().isGanaVisitante()) {
                puntuacion++;
            }

        }
        return puntuacion;
    }

    @Override
    public List<Pronostico> findByUsuarioIdAndPartidoFechaIdId(Long usuarioId, Long fechaId) {

        return pronosticoRepository.findByUsuarioIdAndPartidoFechaIdId(usuarioId, fechaId);
    }

    @Override
    public int calcularPuntosByIdUsuarioYFecha(Long usuarioId, Long fechaId) {
        int puntajeTotal = 0;

        List<Pronostico> pronosticos = this.findByUsuarioIdAndPartidoFechaIdId(usuarioId, fechaId);

        for (Pronostico pronostico : pronosticos) {
            if (pronostico.isGanaLocal() == pronostico.getPartido().isGanaLocal() &&
                    pronostico.isGanaVisitante() == pronostico.getPartido().isGanaVisitante()) {
                puntajeTotal++;
            }
        }

            return puntajeTotal;


    }
}
