package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;

import java.util.List;

public interface MessageServices {
    void insertMessage(String filePath);
    List<Message> selectMessages();
}
