package TuFixTu.FixtureArg.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "idEquipoLocal", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Partido> partidosComoLocal = new HashSet<>();

    @OneToMany(mappedBy = "idEquipoVisitante", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Partido> partidosComoVisitante = new HashSet<>();

    
}
