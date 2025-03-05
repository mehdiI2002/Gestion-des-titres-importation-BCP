package org.gestiondestitresimportationbcp.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
@Service
public class ValidateFilesDefault implements  ValidateFiles {
    @Override
    public boolean validateDDDAndDPDFile(File xmlFile) {
        ClassPathResource xsdResource = new ClassPathResource("static\\DDDAndDPDshema.xsd");
        // Créer une instance de SchemaFactory pour le schéma W3C XML
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try (InputStream xsdStream = xsdResource.getInputStream()){
            // Charger le schéma en utilisant le StreamSource
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdStream));
            // Créer le validateur
            Validator validator = schema.newValidator();
            // Valider le fichier XML
            validator.validate(new StreamSource(xmlFile.getAbsoluteFile()));
        } catch (SAXException e) {
            // La validation a échoué, afficher l'erreur ou la remonter
            return false;
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }
}
