package tn.esprit.springproject.controllers;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Services.IUniversiteService;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.entities.Universite;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class UniversiteController {
    IUniversiteService universiteService;

    @GetMapping("/getAllUniversite")
    public List<Universite> getUniversite(){

        return  universiteService.getAllUniversites();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite (@RequestBody Universite universite){

        return universiteService.addUniversite(universite);
    }
    @PutMapping("/updateUniversite")
    public Universite updateUniversite (@RequestBody Universite universite){
        return universiteService.updateUniversite(universite);
    }
    @DeleteMapping("/deleteUniversite/{idUniversite}")
    public void deleteUniversite(@PathVariable("idUniversite") Long idUniversite){
        universiteService.deleteUniversite(idUniversite);
    }
    @GetMapping("/getUniversiteById/{idUni}")
    public Universite getUniversiteById(@PathVariable("idUni") Long idUniversite){

        return universiteService.getUniversiteById(idUniversite);
    }
    @PutMapping ("/asseignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public  void assignUniversiteToDepartement(@PathVariable("idUniversite") Long idUniversite, @PathVariable("idDepartement") Long idDepartement){
        universiteService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
    @GetMapping("/findUnivByRegion/{region}")
    public  List<Universite>findUniversiteByRegion(@PathVariable("region") String region){
        return universiteService.findUniversiteByRegion(region);
    }
    @GetMapping("/getUniversiteByDepartementEtudiantOpt/{option}")
    public  List<Universite>getUniversiteByDepartementEtudiantOpt(@PathVariable("option")Option option){
        return universiteService.getUniversiteByDepartementEtudiantOpt(option);
    }
    @GetMapping("/getUniv")
    public ResponseEntity<List<Universite>> getAllUnivs(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "nomUniv") String sortBy)
    {
        List<Universite> list = universiteService.getAllUniv(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Universite>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
