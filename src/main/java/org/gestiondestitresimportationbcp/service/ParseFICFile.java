package org.gestiondestitresimportationbcp.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanque;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;
import org.springframework.stereotype.Service;

import java.io.File;
@Service
public class ParseFICFile  implements FileParsingServices {
    private FichiersTitreBanque fichiersTitreBanque;
    @Override
    public DemandeDomiciliationMessage parseFile(File file) {
        return null;
    }

    @Override
    public FichiersTitreBanqueMessage parseFICFIle(File file) {
        try {
            // On crée le contexte JAXB pour la classe racine DemandeDomiciliation
            JAXBContext context = JAXBContext.newInstance(FichiersTitreBanque.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // Désérialisation du fichier XML

            this.fichiersTitreBanque = (FichiersTitreBanque) unmarshaller.unmarshal((file));
        } catch (JAXBException e) {
            System.out.println("erreur de parsing ");
        }
        return fichiersTitreBanque.getFichiersTitreBanqueMessage();

    }
}
