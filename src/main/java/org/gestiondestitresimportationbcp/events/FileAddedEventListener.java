package org.gestiondestitresimportationbcp.events;


import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.repositories.MessageRepository;
import org.gestiondestitresimportationbcp.service.ParserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FileAddedEventListener {

    @Autowired
    private ParserFile parserFile;
    @Autowired
    MessageRepository messageRepository;
    @EventListener
    public void handleFileAddedEvent(FileAddedEvent event) {
        DemandeDomiciliationMessage demandeDomiciliationMessage = parserFile.parseFile(event.getFilePath());
        if (demandeDomiciliationMessage != null) {
            Message message = demandeDomiciliationMessage.getHeaderMessage();
            messageRepository.save(message);
        }
    }
}
