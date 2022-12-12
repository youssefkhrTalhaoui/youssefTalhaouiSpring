package tn.esprit.springproject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name="Universite")
public class Universite implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column (name="idUniv")
    private  Long idUniv;
    private String nomUniv;
    private String region;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Departement> departements;
}
