package TuFixTu.FixtureArg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TuFixTu.FixtureArg.models.Equipo;
import TuFixTu.FixtureArg.service.IEquipoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


    @GetMapping("/list")
    public List<Equipo> getListEquipos(){
        return equipoService.getListEquipo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Long id){
        try {
            Equipo equipo = equipoService.getEquipo(id);
            return equipo != null ? ResponseEntity.ok(equipo) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<Equipo> editEquipo(@PathVariable Long id,
                                             @PathVariable Equipo equipo){
    try {
        Equipo equipoActualizado = equipoService.editEquipo(id, equipo);
        return equipoActualizado != null ? ResponseEntity.ok(equipoActualizado) : ResponseEntity.notFound().build();
         } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }

    }
    
}
