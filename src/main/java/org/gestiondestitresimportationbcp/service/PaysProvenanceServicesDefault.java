package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.PaysProvenanceInfo;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.repositories.PaysProvenanceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaysProvenanceServicesDefault  implements  PaysProvenanceServices{
    @Autowired
    PaysProvenanceInfoRepository paysProvenanceInfoRepository;

    @Override
    public void  insertPaysProvenanceInfo(DemandeDomiciliationMessage demande) {
         PaysProvenanceInfo paysProvenanceInfo =demande.getTitre().getPaysProvenanceInfo();
          paysProvenanceInfoRepository.save(paysProvenanceInfo);

    }
}
