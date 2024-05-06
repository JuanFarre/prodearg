package TuFixTu.FixtureArg.service;

import java.util.List;

import TuFixTu.FixtureArg.models.Usuario;

public interface IUsuarioService {

    List<Usuario> getListUsuarios();

    Usuario getUsuario(Long id);

    String deleteUsuario(Long id);

    Usuario saveUsuario(Usuario usuario);

    Usuario editUsuario(Long id, Usuario usuario);
    
}
