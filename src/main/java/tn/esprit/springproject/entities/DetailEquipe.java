package tn.esprit.springproject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name="DetailEquipe")
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column (name="idDetailEquipe")
    private long  idDetailEquipe;
    private int salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe")
    @JsonIgnore
    private  Equipe equipe;
}
