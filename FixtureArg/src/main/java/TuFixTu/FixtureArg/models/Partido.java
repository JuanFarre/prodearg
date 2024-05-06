package TuFixTu.FixtureArg.models;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partidos")
public class Partido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "equipo_local_id")
  private Equipo idEquipoLocal;

  @ManyToOne
  @JoinColumn(name = "equipo_visitante_id")
  private Equipo idEquipoVisitante;

  private boolean ganaLocal;
  private boolean ganaVisitante;

  @ManyToOne
  @JoinColumn(name = "fecha_id")
  private Fecha fechaId;

  @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Pronostico> pronosticos = new HashSet<>();

}
