package org.gestiondestitresimportationbcp.web;
import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.service.TitreImportationServices;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class RestControllerApp {
   private TitreImportationServices titreImportation;
   public RestControllerApp(TitreImportationServices titreImportation) {
        this.titreImportation = titreImportation;
    }
       @GetMapping("/selectTittles")
    public List<TitreImportationDTO> selectTittles(){
       return  titreImportation.afficherTitreImportation();
    }
    @GetMapping("/detailTitle/{id}")
    public TitreImportationDetailsDTO selectDetailsTitle(@PathVariable Long id) {
        return titreImportation.afficherDetailTitreImportation(id);
    }

}
