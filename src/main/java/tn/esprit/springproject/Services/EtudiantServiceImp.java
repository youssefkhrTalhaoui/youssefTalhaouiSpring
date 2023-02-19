package tn.esprit.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.*;
import tn.esprit.springproject.repository.ContratRepository;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.EquipeRepository;
import tn.esprit.springproject.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class EtudiantServiceImp implements  IEtudiantService{

    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Long id) {

        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {

        return etudiantRepository.findById(id).orElse(null);
    }
    @Override
    public Etudiant findEtudiantByPrenomE(String prenom){
        return  etudiantRepository.findEtudiantByPrenomE(prenom);
    }

    @Override
    public void asseignEtudiantToDepartement(Long idEtudiant, Long idDepartement) {
        Etudiant etudiant = this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement= this.departementRepository.findById(idDepartement).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
       }

       @Override
       @Transactional
    public Etudiant addAsseignEtudiantToEquipeAndContrat(Etudiant e, long idC, Long idEq) {
        Contrat contrat = this.contratRepository.findById(idC).orElse(null);
        Equipe equipe = this.equipeRepository.findById(idEq).orElse(null);
        contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);
        List<Equipe> equipeList=new ArrayList<>();
        equipeList.add(equipe);
        e.setEquipes(equipeList);
        return etudiantRepository.save(e);

    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @Override
    @Transactional
    public void updateEtudiantByOption(Option op, Long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(op, idEtudiant);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(long idDepart) {
        return etudiantRepository.findEtudiantByDepartementIdDepart(idDepart);
    }


}