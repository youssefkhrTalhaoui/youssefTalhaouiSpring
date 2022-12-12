package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;

import java.util.List;


public interface DepartementRepository extends JpaRepository<Departement,Long> {
    @Query("SELECT departement From Departement departement,Etudiant etudiant where departement.idDepart = etudiant.departement.idDepart and etudiant.option =:option")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("option") Option op);
}
