package TuFixTu.FixtureArg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import TuFixTu.FixtureArg.models.Equipo;
import TuFixTu.FixtureArg.repository.IEquipoRepository;



public interface IEquipoService  {

    public List<Equipo> getListEquipo();

    public Equipo getEquipo(Long id);

    public String deleteEquipo(Long id);

    public Equipo saveEquipo(Equipo equipo);

    public Equipo editEquipo(Long id, Equipo equipo);




    
}
