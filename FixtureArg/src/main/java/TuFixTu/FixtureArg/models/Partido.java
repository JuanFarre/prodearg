package TuFixTu.FixtureArg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "partido_equipo",
    joinColumns = @JoinColumn(name = "partido_id"),
    inverseJoinColumns = @JoinColumn(name = "equipo_id"))
    private Set<Equipo> equipos = new HashSet<>();

    private String nombre;

    private boolean ganaLocal;

    private boolean ganaVisitante;


    
}
