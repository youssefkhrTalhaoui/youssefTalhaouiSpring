package tn.esprit.springproject.Services;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repository.ContratRepository;
import tn.esprit.springproject.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class ContratServiceImp implements IContratService {
 ContratRepository contratRepository;
 EtudiantRepository etudiantRepository;
    @Override
    public List<Contrat> getAllContrats() {

        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {

        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findEtudiantByPrenomEAndNomE(prenomE, nomE);
        ce.setEtudiant(etudiant);
        contratRepository.save(ce);
        return ce;
    }


   /* @Scheduled(cron ="* * 13 * * *")
    void retrieveAndUpdateStatusContrat(){
        System.out.println("test retrieveAndUpdateStatus");
    }

    */
}
