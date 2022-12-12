package tn.esprit.springproject.Services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.repository.DetailRepository;
import java.util.List;
@AllArgsConstructor
@Service
public class DetailServiceImp implements IDetailService {

    DetailRepository detailRepository;

    @Override
    public List<DetailEquipe> getAllDetails() {
        return detailRepository.findAll();
    }

    @Override
    public DetailEquipe addDetail(DetailEquipe d) {
        return detailRepository.save(d);
    }

    @Override
    public DetailEquipe updateDetail(DetailEquipe d) {
        return detailRepository.save(d);
    }

    @Override
    public void deleteDetail(Long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public DetailEquipe getDetailById(Long id) {
        return detailRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailRepository.findByThematiqueLike(thematique);
    }

}


