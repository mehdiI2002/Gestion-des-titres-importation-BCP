package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;

import java.util.List;

public interface MessageServices {
    void insertMessage();
    List<Message> selectMessages();
}
