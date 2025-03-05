package org.gestiondestitresimportationbcp;
import org.gestiondestitresimportationbcp.components.DirectoriesInitializer;
import org.gestiondestitresimportationbcp.service.AccuséServiceDefault;
import org.gestiondestitresimportationbcp.service.AccuséServices;
import org.gestiondestitresimportationbcp.service.ValidateFiles;
import org.gestiondestitresimportationbcp.service.WatchFolderServicesDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionDesTitresImportationBcpApplication implements CommandLineRunner {
    @Autowired
    private WatchFolderServicesDefault watchFolder;
    @Autowired
    private DirectoriesInitializer logDirectoryInitializer;

    public static void main(String[] args) {
        SpringApplication.run(GestionDesTitresImportationBcpApplication.class, args);
    }
    @Override
    public void run(String... args) {

        logDirectoryInitializer.createlogFile();
        watchFolder.fileswatcher();
    }
}
