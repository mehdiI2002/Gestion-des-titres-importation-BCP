package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServicesDefault implements MessageServices {

    MessageRepository messageRepository;

    ParserFile parserFile;

    public MessageServicesDefault(MessageRepository messageRepository, ParserFile parserFile) {
        this.messageRepository = messageRepository;
        this.parserFile = parserFile;
    }

    public  void insertMessage(){
       DemandeDomiciliationMessage demandeDomiciliationMessage = parserFile.parseFile();
       Message message = demandeDomiciliationMessage.getHeaderMessage();
       messageRepository.save(message);
    }
    public List<Message> selectMessages() {
      return   messageRepository.findAll();
    }

}
