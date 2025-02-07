package org.gestiondestitresimportationbcp.web;

import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.service.MessageServicesDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageRestController {
   @Autowired
   MessageServicesDefault messageServices;


    @GetMapping("/selectMessage")
    public List<Message> selectMessages(){
        messageServices.insertMessage();
       return  messageServices.selectMessages();
    }


}
