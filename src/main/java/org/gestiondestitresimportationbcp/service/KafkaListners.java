package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListners {
    @Autowired
    ParserFile parserFile;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    OperateurRepository operateurRepository;
    @Autowired
    BanqueRepository banqueRepository;
    @Autowired
    TitreImportationRepository titreImportationRepository;
    @Autowired
    MarchandiseRepository marchandiseRepository;


    @KafkaListener(topics = "DDDTopic",groupId = "DDD")
    void listner (String data ){
          DemandeDomiciliationMessage demande =  parserFile.parseFile(data);
          messageRepository.save(demande.getHeaderMessage());
          operateurRepository.save(demande.getOperateur());
          banqueRepository.save(demande.getBanque());
          titreImportationRepository.save(demande.getTitre());
          marchandiseRepository.save(demande.getMarchandise().getMarchandiseInfo());

    }

}
