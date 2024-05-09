package TuFixTu.FixtureArg.controller;

import java.util.ArrayList;
import java.util.List;

import TuFixTu.FixtureArg.dto.UsuarioPuntuacionDTO;
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

import TuFixTu.FixtureArg.models.Partido;
import TuFixTu.FixtureArg.service.IPartidoService;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private IPartidoService partidoService;

    @PostMapping("/crear")
    public ResponseEntity<Partido> savePartido(@RequestBody Partido partido) {

        try {
            Partido nuevoPartido = partidoService.savePartido(partido);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPartido);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/list")
    public List<Partido> getListPartido(){
        return partidoService.getListPartido();
    }


    @GetMapping("/list/fecha/{id}")
    public List<Partido> getListPartidoByFechaId(@PathVariable Long id){

        return partidoService.findByFechaIdId(id);

    }




    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Long id){
        try {
            Partido partido = partidoService.getPartido(id);
            return partido != null ? ResponseEntity.ok(partido) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
public ResponseEntity<Partido> editPartido(@PathVariable Long id,
                                           @PathVariable Partido partido){
    try {
        Partido partidoActualizado = partidoService.editPartido(id, partido);
        return partidoActualizado != null ? ResponseEntity.ok(partidoActualizado) : ResponseEntity.notFound().build();
    } catch (Exception e) {
        e.printStackTrace(); 
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deletePartido(@PathVariable Long id){
    try{
        String mensaje = partidoService.deletePartido(id);
        return ResponseEntity.ok(mensaje);
    } catch (Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    
}
