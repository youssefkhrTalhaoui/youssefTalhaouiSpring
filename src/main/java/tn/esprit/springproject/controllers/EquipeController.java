package tn.esprit.springproject.controllers;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Services.IEquipeService;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;

import java.util.List;

@AllArgsConstructor
@RestController
public class EquipeController {
    IEquipeService equipeService;
    @GetMapping("/getAllEquipes")
    public List<Equipe> getEquipe(){

        return  equipeService.getAllEquipes();
    }
    @PostMapping("/addEquipe")
    public Equipe addEquipe (@RequestBody Equipe equipe){

        return equipeService.addEquipe(equipe);
    }
    @PutMapping("/updateEquipe")
    public Equipe updateEquipe (@RequestBody Equipe equipe){
        return equipeService.updateEquipe(equipe);
    }
    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public void deleteEquipe(@PathVariable("idEquipe") Long idEquipe){
        equipeService.deleteEquipe(idEquipe);
    }
    @PostMapping("/getEquipeById")
    public Equipe getEquipeById(Long idEquipe){

        return equipeService.getEquipeById(idEquipe);
    }
    @GetMapping("/findEquipeByThematique/{thematique}")
    public  List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable ("thematique") String th){
        return  equipeService.findEquipeByDetailEquipeThematiqueLike(th);
    }
    @GetMapping("findEquipeByIdEtudiant/{idEtudiant}")
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(@PathVariable("idEtudiant") Long idEtudiant){
        return  equipeService.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }
    @GetMapping("/findEquipeByIdThematiqueNotNull/{idEtudiant}")
    public  List<Equipe> findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(@PathVariable("idEtudiant")Long idEtudiant){
        return  equipeService.findEquipeByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }
    @GetMapping("/findByEtudiantAndDepartement/{idEtudiant}/{idDepart}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(@PathVariable("idEtudiant")Long idEtudiant, @PathVariable("idDepart") Long idDepart){
     return equipeService.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }
    @GetMapping("/retriveEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau , @PathVariable("thematique") String thematique){
        return equipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }
    @DeleteMapping("/deleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable("niveau") Niveau niveau){
        equipeService.deleteEquipeByNiveau(niveau);
    }

}
