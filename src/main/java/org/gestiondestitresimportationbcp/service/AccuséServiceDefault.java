package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Date;
import java.util.UUID;
@Service
public class AccuséServiceDefault  implements AccuséServices {
    @Autowired
    ValidateFiles validateFiles;
    @Autowired
    TranformObjectsToAccuseFile tranformObjectsToXmlFile;
    @Autowired
   AccuseTableService accuseTableService;
    @Autowired
    private ParseFICFile parseFICFile;
    @Override
    public boolean generateAccucesDDDAndDPD(File file, DemandeDomiciliationMessage demande) {
        boolean isvalid = false;
        long messageId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            Message headerMessage = new Message(messageId, "190", "PortNet", new Date(), "REP", "R");
            MessageRecuAccuse messageRecu = new MessageRecuAccuse(demande.getHeaderMessage().getNumeroMessage(), demande.getHeaderMessage().getTypeMessage(), 9, demande.getHeaderMessage().getDateMessage());
            if (validateFiles.validateFile(file, "static\\DDDAndDPDshema.xsd")) {
                Accuse accuse = new Accuse("OK", "Prise En charge correct");
                ResponseGeneriqueMessage message = new ResponseGeneriqueMessage(headerMessage, messageRecu, accuse);
                tranformObjectsToXmlFile.tranformReponseToXml(message);
                accuseTableService.insertAccuse(message);
                isvalid = true;
            }
            else {
                Accuse accuse2 = new Accuse("ERROR", "Prise En charge incorrect");
                ResponseGeneriqueMessage message2 = new ResponseGeneriqueMessage(headerMessage, messageRecu, accuse2);
                tranformObjectsToXmlFile.tranformReponseToXml(message2);
            }

        return isvalid;
    }

    @Override
    public boolean generateAccusesFIC(File file,FichiersTitreBanqueMessage fichier ) {
        boolean isvalid = false;
        long messageId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        Message headerMessage = new Message(messageId, "190", "PortNet", new Date(), "REP", "R");
        MessageRecuAccuse messageRecu = new MessageRecuAccuse(fichier.getMessage().getNumeroMessage(), "FIC", 9,fichier.getMessage().getDateMessage());
        if (parseFICFile.isValid()) {
            Accuse accuse = new Accuse("OK", "Prise En charge correct");
            ResponseGeneriqueMessage message = new ResponseGeneriqueMessage(headerMessage, messageRecu, accuse);
            tranformObjectsToXmlFile.tranformReponseToXml(message);
            accuseTableService.insertAccuse(message);
            isvalid = true;
        }
        else {
            Accuse accuse2 = new Accuse("ERROR", "Prise En charge incorrect");
            ResponseGeneriqueMessage message2 = new ResponseGeneriqueMessage(headerMessage, messageRecu, accuse2);
            tranformObjectsToXmlFile.tranformReponseToXml(message2);
        }
        return isvalid;
    }
}



