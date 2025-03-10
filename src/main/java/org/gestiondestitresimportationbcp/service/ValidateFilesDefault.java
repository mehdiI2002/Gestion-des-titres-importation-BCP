package org.gestiondestitresimportationbcp.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@Service
public class ValidateFilesDefault implements  ValidateFiles {
    @Override
    public boolean validateFile(File xmlFile,String filePathshema) {
        ClassPathResource xsdResource = new ClassPathResource(filePathshema);
        // Créer une instance de SchemaFactory pour le schéma W3C XML
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try (InputStream xsdStream = xsdResource.getInputStream()){
            // Charger le schéma en utilisant le StreamSource
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdStream));
            // Créer le validateur
            Validator validator = schema.newValidator();
            // Valider le fichier XML
                     validator.validate(new SAXSource(new InputSource(new FileInputStream(xmlFile))));
        } catch (SAXException e) {
            System.out.println("Erreur"+e.getMessage());

            // La validation a échoué, afficher l'erreur ou la remonter
            return false;
        }
        catch (IOException e) {
            System.out.println("erreur io"+e.getMessage());
            return false;
        }
        System.out.println("xml valider");
        return true;
    }
}
