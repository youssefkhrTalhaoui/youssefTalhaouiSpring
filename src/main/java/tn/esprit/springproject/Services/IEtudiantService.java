package tn.esprit.springproject.Services;

import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Option;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> getAllEtudiants();
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    void deleteEtudiant(Long id);
    Etudiant getEtudiantById(Long id);
    Etudiant findEtudiantByPrenomE(String prenom);
    public  void asseignEtudiantToDepartement(Long idEtudiant,Long idDepartement);
  Etudiant addAsseignEtudiantToEquipeAndContrat(Etudiant e, long idC,Long idEq);
    List<Etudiant> retrieveEtudiantByEquipeThematique (String thematique);
    void updateEtudiantByOption(Option op , Long idEtudiant);
    List <Etudiant> getEtudiantsByDepartement(long idDepart);
}
