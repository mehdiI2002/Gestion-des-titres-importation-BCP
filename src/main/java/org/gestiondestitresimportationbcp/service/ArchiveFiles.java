package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.components.DirectoriesInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
public class ArchiveFiles {
    @Autowired
    DirectoriesInitializer directoriesInitializer;
    public void archivingfileInArchiveAndDeleteFileInFiles(File sourceFile) {

            File archiveFile = directoriesInitializer.createArchiveFile(sourceFile.getName());
            archiveFile = getUniqueFile(archiveFile);
            try {
                Files.copy(sourceFile.toPath(), archiveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                Files.delete(sourceFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();

        }
    }

    private File getUniqueFile(File file) {
        String fileName = file.getName();
        String filePath = file.getParent();
        String baseName = fileName;
        String extension = ".xml";

        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            baseName = fileName.substring(0, dotIndex);
            extension = fileName.substring(dotIndex);
        }
        int count = 1;
        while (file.exists()) {
            file = new File(filePath, baseName + "_" + count + extension);
            count++;
        }
        return file;
    }
    public void archFileInDocsAndDeleteFileInFiles(File file){
        File  archiveFile = directoriesInitializer.createArchiveFile(file.getName());
        try {
            Files.copy(file.toPath(), archiveFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
            Files.delete(file.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

