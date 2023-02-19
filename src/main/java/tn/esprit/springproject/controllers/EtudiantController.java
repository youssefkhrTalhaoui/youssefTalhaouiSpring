package tn.esprit.springproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Services.IEtudiantService;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Option;

import java.util.List;

@AllArgsConstructor
@RestController
public class EtudiantController {

    IEtudiantService etudiantService;

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getEtudiant(){

        return  etudiantService.getAllEtudiants();
    }
    @PostMapping("/AddEtudiant")
    public Etudiant addEtudiant (@RequestBody Etudiant etudiant){

        return etudiantService.addEtudiant(etudiant);
    }


    @PutMapping("/UpdateEtudiant")
    public Etudiant updateEtudiant (@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEtudiant}")
    public void deleteEtudiant(@PathVariable("idEtudiant") Long idEtudiant){
        etudiantService.deleteEtudiant(idEtudiant);
    }

    @GetMapping ("/getEtudiantById")
    public Etudiant getEtudiantById(Long idEtudiant){

        return etudiantService.getEtudiantById(idEtudiant);
    }
    @GetMapping("/findEtudiantByPrenom/{prenom}")
    public Etudiant findEtudiantByPrenomE(@PathVariable("prenom") String prenom){
        return  etudiantService.findEtudiantByPrenomE(prenom);
    }
    @PutMapping("/asseign/{idEtudiant}/{idDepartement}")
    public  void asseignEtudiqntToDepartement(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idDepartement") Long idDepartement){
        etudiantService.asseignEtudiantToDepartement(idEtudiant,idDepartement);
    }
    @PutMapping("/asseignEtudiantToEquipeAndContrat/{idContrat}/{idEquipe}")
    public Etudiant addAsseignEtudiantToEquipeAndContrat(@RequestBody  Etudiant e, @PathVariable("idContrat") long idContrat, @PathVariable("idEquipe") Long idEquipe){
    Etudiant etudiant= etudiantService.addAsseignEtudiantToEquipeAndContrat(e,idContrat,idEquipe);
    return etudiant;
    }
    //@RequestBody quand on va retourner un objet
    @GetMapping("/retrieveEtudiantByEquipeThematique/{thematique}")
    public List <Etudiant> retrieveEtudiantByEquipeThematique (@PathVariable("thematique") String thematique){
       return etudiantService.retrieveEtudiantByEquipeThematique(thematique);

    }
    @PutMapping("/updateEtudiantByOption/{op}/{idEtudiant}")
    public void updateEtudiantByOption(@PathVariable("op") Option op, @PathVariable("idEtudiant") Long idEtudiant) {
        etudiantService.updateEtudiantByOption(op,idEtudiant);
    }
   @GetMapping("/findEtudiantByDepartementIdDepart/{idDepart}")
  public  List<Etudiant>getEtudiantsByDepartement(@PathVariable("idDepart")long idDepart){
        return etudiantService.getEtudiantsByDepartement(idDepart);
   }

}
