package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Contrat;


public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
