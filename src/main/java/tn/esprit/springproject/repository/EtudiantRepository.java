package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Option;

import java.util.List;

public interface EtudiantRepository extends JpaRepository <Etudiant,Long> {
    Etudiant findEtudiantByPrenomE(String prenom);
    @Query("SELECT etudiant FROM Etudiant etudiant join etudiant.equipes equipe join equipe.detailEquipe detail where  detail.thematique = :thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique (String thematique);
    @Modifying
    @Query("update Etudiant etudiant set etudiant.option = :op where etudiant.idEtudiant =:idEtudiant")
     void updateEtudiantByOption(@Param("op") Option op , @Param("idEtudiant") Long idEtudiant);

    //@Query("select  etudiant from Etudiant etudiant where etudiant.nomE =?1 and etudiant.prenomE=?2")
    Etudiant findEtudiantByPrenomEAndNomE(String prenomE,String nomE);


    List <Etudiant> findEtudiantByDepartementIdDepart(long idDepart);

    
}
