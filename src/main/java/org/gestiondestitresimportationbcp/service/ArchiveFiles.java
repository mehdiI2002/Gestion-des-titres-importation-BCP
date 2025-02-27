package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.components.DirectoriesInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
@Service
public class ArchiveFiles {
    @Autowired
    DirectoriesInitializer directoriesInitializer;
    public void archivingfileInArchiveAndDeleteFileInFiles(File  sourceFile) {
        File  archiveFile = directoriesInitializer.createArchiveFile(sourceFile.getName());
        try {
            Files.copy(sourceFile.toPath(), archiveFile.toPath());
            Files.delete(sourceFile.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
