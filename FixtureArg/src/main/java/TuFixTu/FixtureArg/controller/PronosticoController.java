package TuFixTu.FixtureArg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TuFixTu.FixtureArg.models.Pronostico;
import TuFixTu.FixtureArg.service.IPronosticoService;

@RestController
@RequestMapping("/api/pronosticos") // Cambio de ruta base a "/api/pronosticos"
public class PronosticoController {

    @Autowired
    private IPronosticoService pronosticoService; // Cambio de servicio a IPronosticoService

    @PostMapping("/crear") // Cambio de ruta a "/crear"
    public ResponseEntity<Pronostico> savePronostico(@RequestBody Pronostico pronostico) {

        try {
            Pronostico nuevoPronostico = pronosticoService.savePronostico(pronostico);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPronostico);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list") // Cambio de ruta a "/list"
    public List<Pronostico> getListPronosticos() {
        return pronosticoService.getListPronosticos();
    }

    @GetMapping("/{id}") // Cambio de ruta a "/{id}"
    public ResponseEntity<Pronostico> getPronosticoById(@PathVariable Long id) {
        try {
            Pronostico pronostico = pronosticoService.getPronostico(id);
            return pronostico != null ? ResponseEntity.ok(pronostico) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}") // Cambio de ruta a "/edit/{id}"
    public ResponseEntity<Pronostico> editPronostico(@PathVariable Long id,
                                                     @RequestBody Pronostico pronostico) { // Cambio de @PathVariable a @RequestBody
        try {
            Pronostico pronosticoActualizado = pronosticoService.editPronostico(id, pronostico);
            return pronosticoActualizado != null ? ResponseEntity.ok(pronosticoActualizado) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}") // Cambio de ruta a "/delete/{id}"
    public ResponseEntity<String> deletePronostico(@PathVariable Long id) {
        try {
            String mensaje = pronosticoService.deletePronostico(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
