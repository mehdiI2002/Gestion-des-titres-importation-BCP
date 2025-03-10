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
    FichierServices fichierServices;
    @Autowired
    DocumentService documentService;
    @Autowired
    AccuséServices accuséServices;
    @Autowired
    private MessageServices messageServices;
    @EventListener
    public void handleFileCreatedEvent(FileCreatedEvent event) {
        parseAndInsert(event.getFile());
    }
     void parseAndInsert(File file){
        if (file.getName().contains("DDD") || file.getName().contains("DPD")) {
             DemandeDomiciliationMessage message =  fileServicesParsing.parseFile(file);
             if (accuséServices.generateAccucesDDDAndDPD(file, message)) {
                 insertDDDAndDPDInDatabase(message);
             }
         }
         if (file.getName().contains("FIC")) {
                 FichiersTitreBanqueMessage fichierFIC = fileServicesFIC.parseFICFIle(file);
                 if(accuséServices.generateAccusesFIC(file,fichierFIC)) {
                     insertFICFile(fichierFIC);
                 }
             }
         archiveFiles.archivingfileInArchiveAndDeleteFileInFiles(file);
     }
    public void insertDDDAndDPDInDatabase(DemandeDomiciliationMessage demande) {
        messageServices.insertMessage(demande);
        operatorServices.insertOperator(demande);
        banqueServices.insertBank(demande);
        marhandiseServices.insertManrchandise(demande);
        paysProvenanceServices.insertPaysProvenanceInfo(demande);
        titreImportationServices.insertTitle(demande);
    }
public void insertFICFile(FichiersTitreBanqueMessage fichiers){
            messageServices.insertMessage(fichiers);
            fichierServices.insertFile(fichiers);
            documentService.decodeContent(fichiers);
        }
    }