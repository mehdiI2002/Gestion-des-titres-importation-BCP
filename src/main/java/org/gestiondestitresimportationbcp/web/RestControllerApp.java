package org.gestiondestitresimportationbcp.web;
import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.entities.Operator;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.service.FileServices;
import org.gestiondestitresimportationbcp.service.MessageServices;
import org.gestiondestitresimportationbcp.service.OperatorServices;
import org.gestiondestitresimportationbcp.service.TitreImportationServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@RestController
public class RestControllerApp {
   private  MessageServices messageServices;
   private OperatorServices operatorServices;
   private TitreImportationServices titreImportation;
   private FileServices fileServices;

    public RestControllerApp(MessageServices messageServices, OperatorServices operatorServices, TitreImportationServices titreImportation, @Qualifier("uploadFile") FileServices fileServices) {
        this.messageServices = messageServices;
        this.operatorServices = operatorServices;
        this.titreImportation = titreImportation;
        this.fileServices = fileServices;
    }

    @GetMapping("/selectMessage")
    public List<Message> selectMessages(){
        messageServices.insertMessage("src\\main\\resources\\static\\PORTNET_DDD_20220506160729_12650948.xml");
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
    @PostMapping("/processFile")
    public ResponseEntity<String> uploadFile(@RequestParam("files") MultipartFile[] files) {
        if (files.length == 0) {
            return ResponseEntity.badRequest().body("Le fichier est vide");
        }
      else {
       List<String > response =  fileServices.uploadFile(files);
            return ResponseEntity.ok(String.join("\n",response));
        }
    }
}
