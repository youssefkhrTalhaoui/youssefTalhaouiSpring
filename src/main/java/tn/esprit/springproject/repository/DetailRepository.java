package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.DetailEquipe;

import java.util.List;


public interface DetailRepository extends JpaRepository<DetailEquipe,Long> {
    List<DetailEquipe> findByThematiqueLike(String thematique);
}
