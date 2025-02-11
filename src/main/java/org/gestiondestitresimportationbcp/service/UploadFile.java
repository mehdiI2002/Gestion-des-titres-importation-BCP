package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class UploadFile implements FileServices {
    @Override
    public DemandeDomiciliationMessage parseFile(String filePath) {
        return null;
    }
    @Override
    public File uploadFile(String uploadDir, MultipartFile file){
        File  dest = null;
        try {
            dest = new File(uploadDir + file.getOriginalFilename());
            file.transferTo(dest);
        }
            catch (IOException e) {
           System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            }
        return dest;
    }
}
