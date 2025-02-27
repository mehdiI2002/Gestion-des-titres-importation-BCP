package org.gestiondestitresimportationbcp.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliation;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ParseDDDAndDPDFile implements FileParsingServices {
    DemandeDomiciliation demande;
    public ParseDDDAndDPDFile() {
    }
    public DemandeDomiciliationMessage parseFile(File file){
        try {
            // On crée le contexte JAXB pour la classe racine DemandeDomiciliation
            JAXBContext context = JAXBContext.newInstance(DemandeDomiciliation.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Désérialisation du fichier XML

            this.demande = (DemandeDomiciliation) unmarshaller.unmarshal((file));
        } catch (JAXBException e) {
           System.out.println("erreur de parsing ");
        }
        return demande.getDemandeDomiciliationMessage();
    }


    @Override
    public FichiersTitreBanqueMessage parseFICFIle(File file) {
        return null;
    }


}
