package org.gestiondestitresimportationbcp.web;
import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.entities.Operator;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.repositories.TitreImportationRepository;
import org.gestiondestitresimportationbcp.service.MessageServices;
import org.gestiondestitresimportationbcp.service.OperatorServices;
import org.gestiondestitresimportationbcp.service.TitreImportationServices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@RestController
public class RestControllerApp {
   private OperatorServices operatorServices;
   private TitreImportationServices titreImportation;
    public RestControllerApp( OperatorServices operatorServices, TitreImportationServices titreImportation) {
        this.operatorServices = operatorServices;
        this.titreImportation = titreImportation;
    }
    @GetMapping("/selectOperators")
public List<Operator> selectOperators(){
        return operatorServices.selectOperators();
    }
    @GetMapping("/selectTittles")
    public List<TitreImportationDTO> selectTittles(){
       return  titreImportation.afficherTitreImportation();
    }
    @PostMapping("/processFile")
    public ResponseEntity<String> uploadFile(@RequestParam("files") MultipartFile[] files) {
      return null;
    }
}
