package TuFixTu.FixtureArg.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPuntuacionDTO {

    private Long id;
    private String usuario;
    private int puntaje;


}
