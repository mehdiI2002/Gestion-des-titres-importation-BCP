package org.gestiondestitresimportationbcp.service;

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
    private ParserDDD parserservice;
    @Autowired
    private ParserFile parserFile;

    public  void insertMessage(){
        Node root =  parserservice.parseDDDFile("src\\main\\resources\\static\\PORTNET_DDD_20220506160729_12650948.xml");
        Message message = parserFile.parseMessage(root);
        messageRepository.save(message);
    }
    public List<Message> selectMessages(){
      return   messageRepository.findAll();
    }

}
