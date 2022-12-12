package tn.esprit.springproject.Services;

import tn.esprit.springproject.entities.Contrat;


import java.util.List;
public interface IContratService {
    List<Contrat> getAllContrats();
    Contrat addContrat(Contrat c);
    Contrat updateContrat(Contrat c);
    void deleteContrat(Long id);
    Contrat getContratById(Long id);
    Contrat affectContratToEtudiant (Contrat ce, String nomE ,String prenomE );
}
