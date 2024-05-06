package TuFixTu.FixtureArg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TuFixTu.FixtureArg.models.Pronostico;
import TuFixTu.FixtureArg.repository.IPronosticoRepository;

@Service
public class PronosticoService implements IPronosticoService { 
    @Autowired
    private IPronosticoRepository pronosticoRepository; 

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
}