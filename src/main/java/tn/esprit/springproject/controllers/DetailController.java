package tn.esprit.springproject.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Services.IDetailService;
import tn.esprit.springproject.entities.DetailEquipe;
import java.util.List;
@AllArgsConstructor
@RestController
public class DetailController {
    IDetailService detailService;
    @GetMapping("/getAllDetails")
    public List<DetailEquipe> getDetail(){

        return  detailService.getAllDetails();
    }
    @PostMapping("/addDetail")
    public DetailEquipe addDetail (@RequestBody DetailEquipe detailEquipe){

        return detailService.addDetail(detailEquipe);
    }
    @PutMapping("/updateDetail")
    public DetailEquipe updateDetail (@RequestBody DetailEquipe detailEquipe){
        return detailService.updateDetail(detailEquipe);
    }
    @DeleteMapping("/deleteDetail/{idDetail}")
    public void deleteDetail(@PathVariable("idDetail") Long idDetail){
        detailService.deleteDetail(idDetail);
    }
    @PostMapping("/getDetailById")
    public DetailEquipe getDetailById(Long idDetail){

        return detailService.getDetailById(idDetail);
    }
    @GetMapping("/findDetailByThematique/{thematique}")
    public  DetailEquipe findByThematiqueLike(@PathVariable("thematique") String thematique){
        return (DetailEquipe) detailService.findByThematiqueLike(thematique);
    }

}
