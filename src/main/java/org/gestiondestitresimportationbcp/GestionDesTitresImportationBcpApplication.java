package org.gestiondestitresimportationbcp;

import org.gestiondestitresimportationbcp.service.ParserDDD;
import org.gestiondestitresimportationbcp.service.ParserFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Node;

@SpringBootApplication
public class GestionDesTitresImportationBcpApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesTitresImportationBcpApplication.class, args);
    }
    @Override
    public void run(String... args)  {
    }


}
