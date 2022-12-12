package tn.esprit.springproject.Services;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.UniversiteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartementServiceImp implements IDepartementService {
    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;
    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {

        return departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(Long id) {
    departementRepository.deleteById(id);
    }

    @Override
    public Departement getDepartementById(Long id) {

        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op){
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Long idUniv){
        Universite universite = universiteRepository.findById(idUniv).orElse(null);
        return  universite.getDepartements();
    }

    @Scheduled(fixedRate = 60000)
    public  void fixedRateMethod(){
        System.out.println("method with fixed rate");
    }



}
