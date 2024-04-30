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

import TuFixTu.FixtureArg.models.Fecha;
import TuFixTu.FixtureArg.service.IFechaService;

@RestController
@RequestMapping("/api/fechas")
public class FechaController {

    @Autowired
private IFechaService fechaService;

@PostMapping("/crear")
public ResponseEntity<Fecha> saveFecha(@RequestBody Fecha fecha) {
    try {
        Fecha nuevaFecha = fechaService.saveFecha(fecha);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFecha);
    } catch (Exception e) {
        e.printStackTrace(); 
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@GetMapping("/list")
public List<Fecha> getListFecha(){
    return fechaService.getListFecha();
}

@GetMapping("/{id}")
public ResponseEntity<Fecha> getFechaById(@PathVariable Long id){
    try {
        Fecha fecha = fechaService.getFecha(id);
        return fecha != null ? ResponseEntity.ok(fecha) : ResponseEntity.notFound().build();
    } catch (Exception e) {
        e.printStackTrace(); 
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@PutMapping("/edit/{id}")
public ResponseEntity<Fecha> editFecha(@PathVariable Long id,
                                       @PathVariable Fecha fecha){
    try {
        Fecha fechaActualizada = fechaService.editFecha(id, fecha);
        return fechaActualizada != null ? ResponseEntity.ok(fechaActualizada) : ResponseEntity.notFound().build();
    } catch (Exception e) {
        e.printStackTrace(); 
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteFecha(@PathVariable Long id){
    try{
        String mensaje = fechaService.deleteFecha(id);
        return ResponseEntity.ok(mensaje);
    } catch (Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    
}
