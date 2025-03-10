
package org.gestiondestitresimportationbcp.service;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanque;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ParseFICFile implements FileParsingServices {
    private FichiersTitreBanque fichiersTitreBanque;
    private boolean isValid = false ;

    @Override
    public FichiersTitreBanqueMessage parseFICFIle(File file) {
        try {
            // Créer le contexte JAXB pour la classe racine
            JAXBContext context = JAXBContext.newInstance(FichiersTitreBanque.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Charger le schéma XSD depuis le classpath
            ClassPathResource xsdResource = new ClassPathResource("\\static\\FICshema.xsd");
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            try (InputStream xsdStream = xsdResource.getInputStream()) {
                Schema schema = schemaFactory.newSchema(new StreamSource(xsdStream));
                // Affecter le schéma à l'unmarshaller pour activer la validation
                unmarshaller.setSchema(schema);
                isValid = true;
            }
            // Désérialisation du fichier XML (la validation se fait pendant le unmarshalling)
            this.fichiersTitreBanque = (FichiersTitreBanque) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            System.err.println("Erreur de parsing ou de validation XML : " + e.getMessage());
            isValid = false ;
            // On peut également remonter l'exception ou la gérer autrement
        } catch (SAXException e) {
            System.err.println("Erreur de création du schéma XSD : " + e.getMessage());
            isValid = false ;
        } catch (IOException e) {
            System.err.println("Erreur d'E/S lors du chargement du schéma XSD : " + e.getMessage());
            isValid = false ;
        }
        return fichiersTitreBanque != null ? fichiersTitreBanque.getFichiersTitreBanqueMessage() : null;
    }
    @Override
    public DemandeDomiciliationMessage parseFile(File file) {
        return null;
    }

    public boolean isValid() {
        return isValid;
    }
}

