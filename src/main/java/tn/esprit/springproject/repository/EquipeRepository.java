package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;

import java.util.List;

@Repository

public interface EquipeRepository  extends JpaRepository<Equipe,Long>{
List<Equipe>findEquipeByDetailEquipeThematiqueLike(String th);
List<Equipe>findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
List<Equipe>findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant);
List <Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant, Long idDepart);
@Query("SELECT equipe From Equipe equipe , DetailEquipe detail  where equipe.idEquipe = detail.equipe.idEquipe and equipe.niveau =:niveau and detail.thematique =:thematique")
List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau , @Param("thematique") String thematique);

@Modifying
    @Query("DELETE from Equipe equipe where equipe.niveau=:niveau")
     void deleteEquipeByNiveau( Niveau niveau);
}
