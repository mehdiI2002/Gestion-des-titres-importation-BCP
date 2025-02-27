package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;

import java.util.List;

public interface MessageServices {
    void insertMessage( DemandeDomiciliationMessage demandeDomiciliationMessage);
    List<Message> selectMessages();
    void insertMessage (FichiersTitreBanqueMessage fichiersMessage );

}
