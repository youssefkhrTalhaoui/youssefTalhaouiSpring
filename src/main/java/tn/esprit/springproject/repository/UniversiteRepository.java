package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Long>, PagingAndSortingRepository<Universite,Long> {
    List <Universite> findUniversiteByRegion (String region);


    @Query("select universite from Universite universite join universite.departements departement join departement.etudiants etudiant where etudiant.option= ?1")
    List<Universite>getUniversiteByDepartementEtudiantOpt(@Param("option") Option option);

}
