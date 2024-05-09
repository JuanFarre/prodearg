package TuFixTu.FixtureArg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TablaPuntuacionPorFechaDTO {

    private Long fechaId;
    private List<UsuarioPuntuacionDTO> tablaPuntos;


}
