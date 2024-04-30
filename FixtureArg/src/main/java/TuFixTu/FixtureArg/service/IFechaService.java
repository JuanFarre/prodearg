package TuFixTu.FixtureArg.service;

import java.util.List;

import TuFixTu.FixtureArg.models.Fecha;

public interface IFechaService {

    public List<Fecha> getListFecha();

public Fecha getFecha(Long id);

public String deleteFecha(Long id);

public Fecha saveFecha(Fecha fecha);

public Fecha editFecha(Long id, Fecha fecha);

    
}
