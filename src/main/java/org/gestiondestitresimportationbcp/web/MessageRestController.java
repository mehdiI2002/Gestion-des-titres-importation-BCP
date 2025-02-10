package org.gestiondestitresimportationbcp.web;

import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.entities.Operator;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.service.MessageServices;
import org.gestiondestitresimportationbcp.service.OperatorServices;
import org.gestiondestitresimportationbcp.service.TitreImportationServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000") // Permet au frontend React d'accéder à cet endpoint
public class MessageRestController {
   private  MessageServices messageServices;
   private OperatorServices operatorServices;
   private TitreImportationServices titreImportation;
   public  MessageRestController(MessageServices messageServices, OperatorServices operateurServices, TitreImportationServices titreImportation) {
      this.messageServices = messageServices;
      this.operatorServices = operateurServices;
      this.titreImportation = titreImportation;
  }
    @GetMapping("/selectMessage")
    public List<Message> selectMessages(){
        messageServices.insertMessage();
       return  messageServices.selectMessages();
    }
    @GetMapping("/selectOperators")
public List<Operator> selectOperators(){
        operatorServices.insertOperator();
        return operatorServices.selectOperators();
    }
    @GetMapping("/selectTittles")
    public List<TitreImportation> selectTittles(){
       titreImportation.insertTitle();
       return titreImportation.afficherTitreImportation();
    }
    @GetMapping("/processFile/:filePath")
    public  ResponseEntity<Boolean> processFile( @RequestParam String filePath){
        return null;
    }
}
