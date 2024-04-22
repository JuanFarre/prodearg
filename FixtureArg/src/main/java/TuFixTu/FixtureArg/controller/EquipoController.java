package TuFixTu.FixtureArg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TuFixTu.FixtureArg.models.Equipo;
import TuFixTu.FixtureArg.service.IEquipoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private IEquipoService equipoService;

    @PostMapping("/crear")
    public ResponseEntity<Equipo> saveEquipo(@RequestBody Equipo equipo) {

        try {
            Equipo nuevoEquipo = equipoService.saveEquipo(equipo);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
