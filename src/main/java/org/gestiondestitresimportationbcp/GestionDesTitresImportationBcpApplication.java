package org.gestiondestitresimportationbcp;
import org.gestiondestitresimportationbcp.components.DirectoriesInitializer;
import org.gestiondestitresimportationbcp.service.ValidateFiles;
import org.gestiondestitresimportationbcp.service.WatchFolderServicesDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class GestionDesTitresImportationBcpApplication implements CommandLineRunner {
    @Autowired
    private WatchFolderServicesDefault watchFolder;
    @Autowired
    private DirectoriesInitializer logDirectoryInitializer;
    @Autowired
    private ValidateFiles validateFiles;
    public static void main(String[] args) {
        SpringApplication.run(GestionDesTitresImportationBcpApplication.class, args);
    }
    @Override
    public void run(String... args) {
       File file = new File("C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\files\\DDD& DPD\\PORTNET_FIC_20230313125043_3821156.xml");
       validateFiles.validateFile(file,"static\\FICshema.xsd");
        logDirectoryInitializer.createlogFile();
        watchFolder.fileswatcher();
    }
}
