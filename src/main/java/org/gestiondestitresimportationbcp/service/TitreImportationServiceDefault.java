package org.gestiondestitresimportationbcp.service;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.repositories.TitreImportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TitreImportationServiceDefault implements TitreImportationServices {
    @Autowired
   private ParserFile parserFile;
    @Autowired
  private TitreImportationRepository titreImportationRepository;

    @Override
    public void insertTitle() {
        DemandeDomiciliationMessage demandeDomiciliationMessage = parserFile.parseFile("src\\main\\resources\\static\\PORTNET_DDD_20220506160729_12650948.xml");
        TitreImportation titreImportation = demandeDomiciliationMessage.getTitre();
       titreImportationRepository.save(titreImportation);
    }
    @Override
    public List<TitreImportation> afficherTitreImportation() {
        return titreImportationRepository.findAll();
    }
}
