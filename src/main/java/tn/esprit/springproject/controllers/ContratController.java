package tn.esprit.springproject.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Services.IContratService;
import tn.esprit.springproject.entities.Contrat;
import java.util.List;

@AllArgsConstructor
@RestController
public class ContratController {
    IContratService contratService;

    @GetMapping("/getAllContrat")
    public List<Contrat> getContrat(){

        return  contratService.getAllContrats();
    }
    @PostMapping("/AddContrat")
    public Contrat addContrat (@RequestBody Contrat contrat){

        return contratService.addContrat(contrat);
    }
    @PutMapping("/UpdateContrat")
    public Contrat updateContrat (@RequestBody Contrat contrat){
        return contratService.updateContrat(contrat);
    }
    @DeleteMapping("/deleteContrat/{idContrat}")
    public void deleteContrat(@PathVariable("idContrat") Long idContrat){
        contratService.deleteContrat(idContrat);
    }
    @GetMapping("/getContratById")
    public Contrat getContratById(Long idContrat){

        return contratService.getContratById(idContrat);
    }

    @PutMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce ,@PathVariable("nomE")String nomE,@PathVariable("prenomE")String prenomE){
        return  contratService.affectContratToEtudiant(ce,nomE,prenomE);
    }

}
