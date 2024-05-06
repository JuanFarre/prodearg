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

import TuFixTu.FixtureArg.models.Usuario;
import TuFixTu.FixtureArg.service.IUsuarioService;

@RestController
@RequestMapping("/api/usuarios") // Cambio de ruta base a "/api/usuarios"
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService; // Cambio de servicio a IUsuarioService

    @PostMapping("/crear") // Cambio de ruta a "/crear"
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {

        try {
            Usuario nuevoUsuario = usuarioService.saveUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list") // Cambio de ruta a "/list"
    public List<Usuario> getListUsuarios() {
        return usuarioService.getListUsuarios();
    }

    @GetMapping("/{id}") // Cambio de ruta a "/{id}"
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.getUsuario(id);
            return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}") // Cambio de ruta a "/edit/{id}"
    public ResponseEntity<Usuario> editUsuario(@PathVariable Long id,
                                               @RequestBody Usuario usuario) { // Cambio de @PathVariable a @RequestBody
        try {
            Usuario usuarioActualizado = usuarioService.editUsuario(id, usuario);
            return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}") // Cambio de ruta a "/delete/{id}"
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        try {
            String mensaje = usuarioService.deleteUsuario(id);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
