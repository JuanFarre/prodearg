package TuFixTu.FixtureArg.service;

import java.util.List;

import TuFixTu.FixtureArg.models.Partido;

public interface IPartidoService {
    
    public List<Partido> getListPartido();

    public Partido getPartido(Long id);

    public String deletePartido(Long id);

    public Partido savePartido(Partido partido);

    public Partido editPartido(Long id, Partido partido);
}
