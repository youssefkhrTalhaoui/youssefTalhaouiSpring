package tn.esprit.springproject.Services;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;

import java.util.List;

public interface IEquipeService {
    List<Equipe> getAllEquipes();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    void deleteEquipe(Long id);
    Equipe getEquipeById(Long id);
    List<Equipe>findEquipeByDetailEquipeThematiqueLike(String th);
    List<Equipe>findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe>findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant);
    List <Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant, Long idDepart);
    List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau , @Param("thematique") String thematique);
    void deleteEquipeByNiveau( Niveau niveau);
}
