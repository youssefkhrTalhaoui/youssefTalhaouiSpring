package tn.esprit.springproject.Services;

import tn.esprit.springproject.entities.DetailEquipe;

import java.util.List;

public interface IDetailService  {
    List<DetailEquipe> getAllDetails();
    DetailEquipe addDetail(DetailEquipe d);
    DetailEquipe updateDetail(DetailEquipe d);
    void deleteDetail(Long id);
    DetailEquipe getDetailById(Long id);
    List<DetailEquipe> findByThematiqueLike(String thematique);
}
