package org.gestiondestitresimportationbcp.components;

import org.gestiondestitresimportationbcp.service.WatchFolderServicesDefault;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirectoriesInitializer {
    WatchFolderServicesDefault watchFolder;

    public DirectoriesInitializer(WatchFolderServicesDefault watchFolder) {
        this.watchFolder = watchFolder;
    }

    public void createlogFile() {
        File archivedDirectory = new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\logs");
        if (!archivedDirectory.exists()) {
            archivedDirectory.mkdirs();
        }
        File directoryFiles = new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\Files");
        if (!directoryFiles.exists()) {
            directoryFiles.mkdirs();
        }
        File archiveDirectory = new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\Archives");
        if (!archiveDirectory.exists()) {
            archiveDirectory.mkdirs();
        }
        File repDocs = new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\docs");
        if(!repDocs.exists()){
            repDocs.mkdirs();
        }
    }
    public File createArchiveFile(String fileName) {
        File archiveFile = new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\Archives\\" + fileName);
        return archiveFile;
    }


}
