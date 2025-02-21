package org.gestiondestitresimportationbcp.service;
import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.entities.Operator;

import org.gestiondestitresimportationbcp.entities.PaysProvenanceInfo;
import org.gestiondestitresimportationbcp.mappers.TitreImportationDTOMapper;
import org.gestiondestitresimportationbcp.mappers.TitreImportationDetailsDTOMapper;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.repositories.PaysProvenanceInfoRepository;
import org.gestiondestitresimportationbcp.repositories.TitreImportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitreImportationServiceDefault implements TitreImportationServices {
    @Autowired
  private TitreImportationRepository titreImportationRepository;
    @Autowired
    private TitreImportationDTOMapper titreImportationDTOMapper;
    @Autowired
    private TitreImportationDetailsDTOMapper titreImportationDetailsDTOMapper;


     @Autowired
    PaysProvenanceInfoRepository paysProvenanceInfoRepository;
    @Override
    public void insertTitle( DemandeDomiciliationMessage demandeDomiciliationMessage) {
        TitreImportation titreImportation = demandeDomiciliationMessage.getTitre();
        Operator operateur = demandeDomiciliationMessage.getOperateur();
        titreImportation.setOperator(operateur);
        titreImportation.setMessage(demandeDomiciliationMessage.getHeaderMessage());
        titreImportation.setBanque(demandeDomiciliationMessage.getBanque());
        titreImportation.setMarchandiseInfo(demandeDomiciliationMessage.getMarchandise().getMarchandiseInfo());
        PaysProvenanceInfo paysProvenanceInfo = demandeDomiciliationMessage.getTitre().getPaysProvenanceInfo();
        titreImportation.setPaysProvenanceInfo(paysProvenanceInfo);
        titreImportationRepository.save(titreImportation);
    }
    @Override
    public List<TitreImportationDTO> afficherTitreImportation() {
        return titreImportationRepository.findAll()
                .stream()
                .map(titreImportationDTOMapper)
                .collect(Collectors.toList());
    }
    @Override
    public TitreImportationDetailsDTO afficherDetailTitreImportation(Long id) {
        return titreImportationRepository.findById(id)
                .map(titreImportationDetailsDTOMapper::apply)
                .orElse(null);
    }
}
