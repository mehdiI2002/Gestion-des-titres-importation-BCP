package org.gestiondestitresimportationbcp;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.gestiondestitresimportationbcp.entities.DemandeDomiciliation;
import org.gestiondestitresimportationbcp.entities.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class GestionDesTitresImportationBcpApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesTitresImportationBcpApplication.class, args);
    }
    @Override
    public void run(String... args)  {
        try {
            // On crée le contexte JAXB pour la classe racine DemandeDomiciliation
            JAXBContext context = JAXBContext.newInstance(DemandeDomiciliation.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Désérialisation du fichier XML
            File file = new File("src\\main\\resources\\static\\PORTNET_DDD_20220506160729_12650948.xml");
            DemandeDomiciliation demande = (DemandeDomiciliation) unmarshaller.unmarshal(file);

            // Utilisation des données
            Message header = demande.getDemandeDomiciliationMessage().getMessage();
            System.out.println("Numéro de message : " + header.getNumeroMessage());
            System.out.println("DateMesage : "+header.getDateMessage());


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
