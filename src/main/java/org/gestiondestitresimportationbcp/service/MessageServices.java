package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;

import java.util.List;

public interface MessageServices {
    void insertMessage( DemandeDomiciliationMessage demandeDomiciliationMessage);
    List<Message> selectMessages();
}
