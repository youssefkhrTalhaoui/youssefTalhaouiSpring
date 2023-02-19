package tn.esprit.springproject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "Equipe")
public class Equipe implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="idEquipe")
    private Long idEquipe;
    private String nomEquipe;
    @Enumerated (EnumType.STRING)
    private  Niveau niveau;
    @OneToOne
    private DetailEquipe detailEquipe;
    @ManyToMany
    @JsonIgnore //pour le break de la boucle ;
    private List<Etudiant> etudiants;
}
