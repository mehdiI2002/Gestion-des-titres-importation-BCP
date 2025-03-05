package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.models.Accuse;
import org.gestiondestitresimportationbcp.models.MessageRecu;
import org.gestiondestitresimportationbcp.models.ResponseGeneriqueMessage;
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
    TranformObjectsToXmlFile tranformObjectsToXmlFile;
    @Override
    public boolean generateAccuces(File file) {
        boolean isvalid = false;
        String typeFile = null;
        if(file.getName().contains("DDD")){
            typeFile = "DDD";
        }
        else if ( file.getName().contains("DPD")){
            typeFile = "DPD";
        }
        else if ( file.getName().contains("FIC")){
            typeFile = "FIC";
        }
        long messageId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        Message headerMessage = new Message(messageId, "190", "PortNet", new Date(), "REP", "R");
        MessageRecu messageRecu = new MessageRecu(233444, typeFile, 9, new Date());
        if (validateFiles.validateDDDAndDPDFile(file)) {
            Accuse accuse = new Accuse("OK", "Prise En charge correct");
            ResponseGeneriqueMessage message = new ResponseGeneriqueMessage(headerMessage, messageRecu, accuse);
            tranformObjectsToXmlFile.tranformReponseToXml(message);
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
