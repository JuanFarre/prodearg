package TuFixTu.FixtureArg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TuFixTu.FixtureArg.models.Fecha;
import TuFixTu.FixtureArg.repository.IFechaRepository;

@Service
public class FechaService implements IFechaService {

    @Autowired
    private IFechaRepository fechaRepository;

    @Override
    public List<Fecha> getListFecha() {
        return fechaRepository.findAll();
    }

    @Override
    public Fecha getFecha(Long id) {
        return fechaRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteFecha(Long id) {
        fechaRepository.deleteById(id);
        return "Fecha borrada";
    }

    @Override
    public Fecha saveFecha(Fecha fecha) {
        return fechaRepository.save(fecha);
    }

    @Override
    public Fecha editFecha(Long id, Fecha fecha) {
        Fecha fechaExistente = this.getFecha(id);
        if(fechaExistente != null){
            fecha.setId(id); // Asegurarse de que la fecha tenga el mismo ID que la fecha existente
            fechaExistente = fechaRepository.save(fecha);
        }
        return fechaExistente;
    }
}
