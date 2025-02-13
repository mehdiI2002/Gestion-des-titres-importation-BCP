package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadFile implements FileServices {
    private KafkaServices kafkaServices;
    public UploadFile(KafkaServices kafkaServices) {
        this.kafkaServices = kafkaServices;
    }

    @Override
    public DemandeDomiciliationMessage parseFile(String filePath) {
        return null;
    }
    public List<String> uploadFile(MultipartFile[] files) {
        List<java.lang.String> accuesFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                java.lang.String content = new String(file.getBytes());
                accuesFiles.add("le fichier " + file.getOriginalFilename() + " est envoyé avec succès");
                kafkaServices.sendMessage(content);
            } catch (IOException e) {
                accuesFiles.add("Erreur lors de l'envoi du fichier " + file.getOriginalFilename() + ": " + e.getMessage());
            }
        }
        return accuesFiles;
    }

}
