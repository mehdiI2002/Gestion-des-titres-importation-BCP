package org.gestiondestitresimportationbcp;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.service.WatchFolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestionDesTitresImportationBcpApplication implements CommandLineRunner {
    @Autowired
    private WatchFolder watchFolder;
    public static void main(String[] args) {
        SpringApplication.run(GestionDesTitresImportationBcpApplication.class, args);
    }

    @Override
    public void run(String... args) {
        watchFolder.fileswatcher();

    }
}
