package TuFixTu.FixtureArg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TuFixTu.FixtureArg.models.Equipo;
import TuFixTu.FixtureArg.repository.IEquipoRepository;

@Service
public class EquipoService implements IEquipoService {

    @Autowired
    private IEquipoRepository equipoRepository;

    @Override
    public List<Equipo> getListEquipo() {
        
        return equipoRepository.findAll();

    }

    @Override
    public Equipo getEquipo(Long id) {

        return equipoRepository.findById(id).orElse(null);

    }

    @Override
    public String deleteEquipo(Long id) {
        
        equipoRepository.deleteById(id);

        return "Equipo borrado";

    }

    @Override
    public Equipo saveEquipo(Equipo equipo) {
       
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo editEquipo(Long id, Equipo equipo) {
        Equipo equiponew = new Equipo();

        if(equiponew!=null){
            //get id a editar
            equiponew = this.getEquipo(id);

            //guardamos el equipo nuevo en el id que encontramos arriba
            equiponew = equipoRepository.save(equipo);
        }

        return equiponew;
       

    }
    
}
