package org.gestiondestitresimportationbcp.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.gestiondestitresimportationbcp.models.ResponseGenerique;
import org.gestiondestitresimportationbcp.models.ResponseGeneriqueMessage;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TranformObjectsToXmlFile {
    public void tranformReponseToXml(ResponseGeneriqueMessage message){
        try{
        ResponseGenerique response = new ResponseGenerique(message);
        JAXBContext context = JAXBContext.newInstance(ResponseGenerique.class);

        // Créer le marshaller pour convertir l'objet en XML
        Marshaller marshaller = context.createMarshaller();

        // Formater le XML pour être lisible
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String directoryPath = "C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\Accusé\\";
            Date dateMessage = message.getHeaderMessage().getDateMessage();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String formattedDate = dateFormat.format(dateMessage);

            String fileName = message.getHeaderMessage().getEmetteur() + "_"
                    + message.getHeaderMessage().getTypeMessage() + "_"
                    + formattedDate
                    + message.getHeaderMessage().getNumeroMessage()+".xml";
        // Écrire l'objet dans un fichier XML
        File file = new File(directoryPath+fileName);
        marshaller.marshal(response, file);
    } catch (JAXBException e) {
        e.printStackTrace();
    }
    }
}
