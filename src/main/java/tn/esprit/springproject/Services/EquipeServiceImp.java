package tn.esprit.springproject.Services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;
import tn.esprit.springproject.repository.EquipeRepository;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service

public class EquipeServiceImp implements IEquipeService {
    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
        public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant, Long idDepart) {
        return equipeRepository.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @Override
    @Transactional
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRepository.deleteEquipeByNiveau(niveau);
    }


}

