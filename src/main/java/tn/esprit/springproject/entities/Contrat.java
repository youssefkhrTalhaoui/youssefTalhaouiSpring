package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table ( name= "Contrat")
public class Contrat implements Serializable {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name ="idContrat")
    private long idContrat;
    @Temporal (TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal (TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated (EnumType.STRING)
    private Specialite specialite;
    private  Boolean archive;
    @ManyToOne
    @JsonIgnore
    Etudiant etudiant;
}
