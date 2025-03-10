package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.AccuseTable;
import org.gestiondestitresimportationbcp.models.ResponseGeneriqueMessage;
import org.gestiondestitresimportationbcp.repositories.AccuseTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccuseTableServiceDefault implements AccuseTableService {
    @Autowired
    private AccuseTableRepository accuseTableRepository;
    @Override
    public void insertAccuse(ResponseGeneriqueMessage responseAccuse) {
        AccuseTable accuseTable = new AccuseTable(responseAccuse.getHeaderMessage().getNumeroMessage(),
                responseAccuse.getHeaderMessage().getEmetteur(),responseAccuse.getHeaderMessage().getDestinataire(),
                responseAccuse.getHeaderMessage().getDateMessage(),responseAccuse.getHeaderMessage().getTypeMessage(),
                responseAccuse.getHeaderMessage().getFonction(),responseAccuse.getMessageRecu().getReferenceEmetteur(),responseAccuse.getMessageRecu().getTypeMessage()
        ,responseAccuse.getMessageRecu().getFonction(),responseAccuse.getMessageRecu().getDate(), responseAccuse.getAccuse().getCode(),responseAccuse.getAccuse().getDescription());
        accuseTableRepository.save(accuseTable);
    }
}
