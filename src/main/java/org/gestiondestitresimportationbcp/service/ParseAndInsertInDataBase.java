package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.components.DirectoriesInitializer;
import org.gestiondestitresimportationbcp.events.FileCreatedEvent;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class ParseAndInsertInDataBase {
        @Qualifier("parseDDDAndDPDFile")
        @Autowired
        private FileParsingServices fileServicesParsing;
        @Qualifier("parseFICFile")
        @Autowired
        private FileParsingServices fileServicesFIC;
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
        @Autowired
        private ArchiveFiles archiveFiles;
        @Autowired
        DirectoriesInitializer directoriesInitializer;
        @Autowired
        FichierServices fichierServices ;
        @Autowired
       DocumentService documentService;
       @Autowired
       AccuséServices accuséServices;

    @EventListener
        public void handleFileCreatedEvent(FileCreatedEvent event) {
        if(accuséServices.generateAccuces(event.getFile())) {
            parseAndInsert(event.getFile());

        }
        archiveFiles.archivingfileInArchiveAndDeleteFileInFiles(event.getFile());
        }
        public void parseAndInsert(File file) {

        if(file.getName().contains("DDD") || file.getName().contains("DPD")) {
            DemandeDomiciliationMessage demande = fileServicesParsing.parseFile(file);
            messageServices.insertMessage(demande);
            operatorServices.insertOperator(demande);
            banqueServices.insertBank(demande);
            marhandiseServices.insertManrchandise(demande);
            paysProvenanceServices.insertPaysProvenanceInfo(demande);
            titreImportationServices.insertTitle(demande);
        }
        else if (file.getName().contains("FIC")){
            FichiersTitreBanqueMessage fichiers   = fileServicesFIC.parseFICFIle(file);
            messageServices.insertMessage(fichiers);
            fichierServices.insertFile(fichiers);
            documentService.decodeContent(fichiers);
        }
    }
}
