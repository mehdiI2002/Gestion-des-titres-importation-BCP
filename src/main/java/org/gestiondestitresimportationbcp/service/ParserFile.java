package org.gestiondestitresimportationbcp.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliation;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@Service
public class ParserFile implements FileServices{
    DemandeDomiciliation demande;

    public ParserFile() {
    }

    public DemandeDomiciliationMessage parseFile(String filPath){
        try {
            // On crée le contexte JAXB pour la classe racine DemandeDomiciliation
            JAXBContext context = JAXBContext.newInstance(DemandeDomiciliation.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Désérialisation du fichier XML
            File file = new File(filPath);
            this.demande = (DemandeDomiciliation) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
           System.out.println("erreur de parsing ");
        }
        return demande.getDemandeDomiciliationMessage();
    }

    @Override
    public File uploadFile(String uploadDir, MultipartFile file) {
        return null;
    }
}
