package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import java.util.List;

@Service
public class MessageServicesDefault implements MessageServices {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ParserFile parserFile;

    public  void insertMessage(){
       DemandeDomiciliationMessage demandeDomiciliationMessage = parserFile.parseFile();
       Message message = demandeDomiciliationMessage.getMessage();
       messageRepository.save(message);
    }
    public List<Message> selectMessages() {
      return   messageRepository.findAll();
    }

}
