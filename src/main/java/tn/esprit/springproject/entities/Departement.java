package tn.esprit.springproject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name="Departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column (name="idDepart")
    private  long idDepart;
    private String nomDepart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Etudiant> etudiants;
}
