package TuFixTu.FixtureArg.service;

import java.util.List;

import TuFixTu.FixtureArg.models.Pronostico;
import TuFixTu.FixtureArg.models.Usuario;

public interface IPronosticoService {

    
    List<Pronostico> getListPronosticos();

    Pronostico getPronostico(Long id);

    String deletePronostico(Long id);

    Pronostico savePronostico(Pronostico pronostico);

    Pronostico editPronostico(Long id, Pronostico pronostico);

    int calcularPuntosByIdUsuario (Long id);
    
}
