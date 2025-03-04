package org.gestiondestitresimportationbcp.web;
import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.models.TitreImportationId;
import org.gestiondestitresimportationbcp.service.ConvertToPdf;
import org.gestiondestitresimportationbcp.service.TitreImportationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
public class RestControllerApp {
   private TitreImportationServices titreImportation;
   @Autowired
   private ConvertToPdf convertToPdf;
   public RestControllerApp(TitreImportationServices titreImportation) {
        this.titreImportation = titreImportation;
    }
       @GetMapping("/selectTittles")
    public List<TitreImportationDTO> selectTittles(){
       return  titreImportation.afficherTitreImportation();
    }
    @GetMapping("/detailTitle/{numEnregistrement}/{headerMessage}")
    public TitreImportationDetailsDTO selectDetailsTitle(@PathVariable Long numEnregistrement , @PathVariable Long headerMessage ) {
        TitreImportationId id = new TitreImportationId(numEnregistrement,headerMessage);
        return titreImportation.afficherDetailTitreImportation(id);
    }
    @GetMapping ("/downloadPdf")
    public ResponseEntity<FileSystemResource> transformFileToPDF(@RequestParam String filePath) throws IOException {
       return convertToPdf.transformFileToPDF(filePath);


    }

}
