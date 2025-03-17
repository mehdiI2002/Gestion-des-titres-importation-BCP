package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Fichier;
import org.gestiondestitresimportationbcp.entities.PdfFile;

import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.List;
import java.io.FileOutputStream;
import java.nio.file.Paths;


@Service
public class DocumentService {
@Autowired
PdfFileServices pdfFileServices;
    private final String uploadDir = "C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\docs";  // Dossier de stockage

    public void decodeContent(FichiersTitreBanqueMessage message) {
        List<Fichier> fichiers = message.getFichierInfo().getFichiers();

        for (Fichier fichier : fichiers) {
            System.out.println("Nom du fichier : " + fichier.getNom());
            String contenu = fichier.getContenu();

            if (contenu != null && !contenu.isEmpty()) {
                try {
                    // Nettoyer la chaîne Base64 (retirer les espaces et retours à la ligne)
                    contenu = contenu.replaceAll("\\s+", "");

                    // Décoder le contenu Base64 en bytes
                    byte[] decodedBytes = Base64.getDecoder().decode(contenu);

                    // Chemin de stockage du fichier PDF
                    String pdfFilePath = Paths.get(uploadDir, fichier.getNom()).toString();

                    // Enregistrer les bytes dans un fichier PDF
                    try (FileOutputStream fos = new FileOutputStream(pdfFilePath)) {
                        fos.write(decodedBytes);
                        System.out.println("Le fichier PDF a été enregistré à : " + pdfFilePath);
                        Long numEnregistrement = message.getTitreFIC().getNumEnregistrement();
                        System.out.println("numenregistrement "+ numEnregistrement);
                        PdfFile pdf = new PdfFile(null,pdfFilePath,numEnregistrement);

                        pdfFileServices.insertPdfFile(pdf);

                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur de décodage Base64 pour le fichier " + fichier.getNom() + ": " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erreur lors de la sauvegarde du fichier PDF : " + e.getMessage());
                }
            } else {
                System.out.println("Le fichier " + fichier.getNom() + " est vide ou null.");
            }
        }
    }
}
