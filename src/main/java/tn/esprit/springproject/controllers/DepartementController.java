package tn.esprit.springproject.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Services.IDepartementService;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.repository.DepartementRepository;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class DepartementController {

    IDepartementService departementService;


    @GetMapping("/getAllDepartement")
    public List<Departement> getDepartement(){

        return  departementService.getAllDepartements();
    }

    @PostMapping("/addDepartement")
    public Departement addDepartement (@RequestBody Departement departement){

        return departementService.addDepartement(departement);
    }
    @PutMapping("/updateDepartement")
    public Departement updateDepartement (@RequestBody Departement departement){
        return departementService.updateDepartement(departement);
    }
    @DeleteMapping("/deleteDepartement/{idDepartement}")
    public void deleteDepartement(@PathVariable("idDepartement") Long idDepartement){
        departementService.deleteDepartement(idDepartement);
    }
    @GetMapping("/getDepartementById/{idDepartement}")
    public Departement getDepartementById( @PathVariable("idDepartement")Long idDepartement){

        return departementService.getDepartementById(idDepartement);
    }
    @GetMapping("/getDepartementByEtdOption/{op}")
    public List<Departement> retrieveDepartementByOptionEtudiant(@PathVariable("op") Option op){
        return departementService.retrieveDepartementByOptionEtudiant(op);
    }
    @GetMapping("/retrieveDepartementsByUniversite/{idUniv}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniv") Long idUniv){
        return departementService.retrieveDepartementsByUniversite(idUniv);
    }

}
