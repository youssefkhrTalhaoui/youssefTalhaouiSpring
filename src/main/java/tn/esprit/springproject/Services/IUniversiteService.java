package tn.esprit.springproject.Services;

import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> getAllUniversites();
    List<Universite> getAllUniv(Integer pageNo, Integer pageSize, String sortBy);

    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    void deleteUniversite(Long id);
    Universite getUniversiteById(Long id);
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement);
    List <Universite> findUniversiteByRegion (String region);
    List<Universite>getUniversiteByDepartementEtudiantOpt(@Param("option") Option option);
}
