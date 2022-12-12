package tn.esprit.springproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated (EnumType.STRING)
    private Option option;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private Set<Contrat> contrats;
    @ManyToOne
    @JsonIgnore
    Departement departement;
    @ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "etudiants")
    private List<Equipe> equipes;



}
