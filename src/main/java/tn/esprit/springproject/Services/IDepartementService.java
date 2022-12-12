package tn.esprit.springproject.Services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;

import java.util.List;

public interface IDepartementService {
    List<Departement> getAllDepartements();
    Departement addDepartement(Departement d);
    Departement updateDepartement(Departement d);
    void deleteDepartement(Long id);
    Departement getDepartementById(Long id);
    List<Departement> retrieveDepartementByOptionEtudiant(Option op);
    public List<Departement> retrieveDepartementsByUniversite(Long idUniv);

}
