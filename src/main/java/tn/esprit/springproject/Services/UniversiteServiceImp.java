package tn.esprit.springproject.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.entities.Universite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImp implements IUniversiteService{
    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Universite> getAllUniversites() {

        return universiteRepository.findAll();
    }

    @Override
    public List<Universite> getAllUniv(Integer pageNo, Integer pageSize, String sortBy) {

        {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

            Page<Universite> pagedResult = universiteRepository.findAll(paging);

            if (pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<Universite>();
            }
        }
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);
    }

    @Override
    public List<Universite> findUniversiteByRegion(String region) {
        return universiteRepository.findUniversiteByRegion(region);
    }

    @Override
    public List<Universite> getUniversiteByDepartementEtudiantOpt(Option option) {
        return universiteRepository.getUniversiteByDepartementEtudiantOpt(option);
    }
}
