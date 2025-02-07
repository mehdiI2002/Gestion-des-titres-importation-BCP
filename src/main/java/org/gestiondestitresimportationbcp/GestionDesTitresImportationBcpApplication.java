package org.gestiondestitresimportationbcp;

import org.gestiondestitresimportationbcp.service.ParseMessage;
import org.gestiondestitresimportationbcp.service.ParserDDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Node;

@SpringBootApplication
public class GestionDesTitresImportationBcpApplication implements CommandLineRunner {
    private ParserDDD parserservice;
    @Autowired
    private ParseMessage parserMessage;
    public GestionDesTitresImportationBcpApplication(ParserDDD parserservice){
        this.parserservice = parserservice;

    }
    public static void main(String[] args) {
        SpringApplication.run(GestionDesTitresImportationBcpApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Node root =  parserservice.parseDDDFile("src\\main\\resources\\static\\PORTNET_DDD_20220506160729_12650948.xml");
        parserMessage.parseMessage(root);

    }

}
