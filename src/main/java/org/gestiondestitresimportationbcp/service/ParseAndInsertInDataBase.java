package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.events.FileCreatedEvent;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class ParseAndInsertInDataBase {
        @Qualifier("parserFile")
        @Autowired
        private FileServices fileServicesParsing;
        @Autowired
        private MessageServices messageServices;
        @Autowired
        private OperatorServices operatorServices;
        @Autowired
        private BanqueServices banqueServices;
        @Autowired
        private TitreImportationServices titreImportationServices;
        @Autowired
        private MarhandiseServices marhandiseServices;
        @Autowired
        private PaysProvenanceServices paysProvenanceServices;
        @EventListener
        public void handleFileCreatedEvent(FileCreatedEvent event) {
            parseAndInsert(event.getFile());
        }
        public void parseAndInsert(File file) {
            DemandeDomiciliationMessage demande = fileServicesParsing.parseFile(file);
            messageServices.insertMessage(demande);
            operatorServices.insertOperator(demande);
            banqueServices.insertBank(demande);
            marhandiseServices.insertManrchandise(demande);
            paysProvenanceServices.insertPaysProvenanceInfo(demande);
            titreImportationServices.insertTitle(demande);
        }
    }





