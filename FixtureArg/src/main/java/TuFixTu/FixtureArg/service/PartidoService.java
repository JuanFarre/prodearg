package TuFixTu.FixtureArg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TuFixTu.FixtureArg.models.Partido;
import TuFixTu.FixtureArg.repository.IPartidoRepository;

@Service
public class PartidoService implements IPartidoService {

    @Autowired
    private IPartidoRepository partidoRepository;

    @Override
    public List<Partido> getListPartido() {
        
        return partidoRepository.findAll();

    }

    @Override
    public Partido getPartido(Long id) {

        return partidoRepository.findById(id).orElse(null);

    }

    @Override
    public String deletePartido(Long id) {
        
        partidoRepository.deleteById(id);

        return "Equipo borrado";

    }

    @Override
    public Partido savePartido(Partido partido) {
       
        return partidoRepository.save(partido);
    }

    @Override
    public Partido editPartido(Long id, Partido partido) {
        Partido partidonew = new Partido();

        if(partidonew!=null){

            partidonew = this.getPartido(id);

            partidonew = partidoRepository.save(partido);
        }

        return partidonew;
       

    }
    
}
