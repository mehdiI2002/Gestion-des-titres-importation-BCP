package org.gestiondestitresimportationbcp;

import org.gestiondestitresimportationbcp.components.DirectoriesInitializer;
import org.gestiondestitresimportationbcp.service.WatchFolderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestionDesTitresImportationBcpApplication  implements CommandLineRunner {
    @Autowired
    private WatchFolderServices watchFolder;
    @Autowired
    DirectoriesInitializer  logDirectoryInitializer;
    public static void main(String[] args) {
        SpringApplication.run(GestionDesTitresImportationBcpApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        logDirectoryInitializer.createlogFile();
        watchFolder.fileswatcher();
    }

}
