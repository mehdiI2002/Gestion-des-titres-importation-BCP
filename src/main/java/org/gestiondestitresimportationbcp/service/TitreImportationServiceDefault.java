package org.gestiondestitresimportationbcp.service;
import jakarta.transaction.Transactional;
import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.entities.Operator;

import org.gestiondestitresimportationbcp.entities.PaysProvenanceInfo;
import org.gestiondestitresimportationbcp.mappers.TitreImportationDTOMapper;
import org.gestiondestitresimportationbcp.mappers.TitreImportationDetailsDTOMapper;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.models.TitreImportationId;
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
    @Autowired
    PdfFileServices pdfFileServices;
    @Transactional
    public void insertTitle(DemandeDomiciliationMessage demandeDomiciliationMessage) {
        TitreImportation titreImportation = demandeDomiciliationMessage.getTitre();
        Operator operateur = demandeDomiciliationMessage.getOperateur();
        titreImportation.setOperator(operateur);
        titreImportation.setMessage(demandeDomiciliationMessage.getHeaderMessage());
        titreImportation.setBanque(demandeDomiciliationMessage.getBanque());
        titreImportation.setMarchandiseInfo(demandeDomiciliationMessage.getMarchandise().getMarchandiseInfo());
        PaysProvenanceInfo paysProvenanceInfo = demandeDomiciliationMessage.getTitre().getPaysProvenanceInfo();
        titreImportation.setPaysProvenanceInfo(paysProvenanceInfo);
        Long  messageTitle = titreImportation.getMessage().getNumeroMessage();
         Long numEnregistrement = titreImportation.getNumEnregistrement();
        TitreImportationId id  = new TitreImportationId(numEnregistrement,messageTitle);
        titreImportation.setId(id);


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
    public TitreImportationDetailsDTO afficherDetailTitreImportation(TitreImportationId id) {
        TitreImportationDetailsDTO detailsDTO = titreImportationRepository.findByIdNumEnregistrementAndIdNumeroMessage(
                        id.getNumEnregistrement(),
                        id.getNumeroMessage())
                .map(titreImportationDetailsDTOMapper::apply)
                .orElse(null);

        if (detailsDTO != null) {
            List<String> pdfFilePaths = pdfFileServices.selectPdfsFortitle(id.getNumEnregistrement());
            if (pdfFilePaths != null) {
                return new TitreImportationDetailsDTO(
                        detailsDTO.numeroMessage(),
                        detailsDTO.emetteur(),
                        detailsDTO.destinataire(),
                        detailsDTO.dateMessage(),
                        detailsDTO.typeMessage(),
                        detailsDTO.fonction(),
                        detailsDTO.idFicalUnique(),
                        detailsDTO.nom(),
                        detailsDTO.centre(),
                        detailsDTO.typeIdentification(),
                        detailsDTO.numIdentification(),
                        detailsDTO.identifiantDouane(),
                        detailsDTO.ribBancaire(),
                        detailsDTO.codeBanque(),
                        detailsDTO.guichet(),
                        detailsDTO.localite(),
                        detailsDTO.numEnregistrement(),
                        detailsDTO.Categorie(),
                        detailsDTO.typeDedmande(),
                        detailsDTO.importateur(),
                        detailsDTO.expediteur(),
                        detailsDTO.regimeDouanier(),
                        detailsDTO.bureauDouanier(),
                        detailsDTO.montantTotale(),
                        detailsDTO.montantFOB(),
                        detailsDTO.motantFret(),
                        detailsDTO.montantAssuranceAcessoires(),
                        detailsDTO.devise(),
                        detailsDTO.ConditionsLivraison(),
                        detailsDTO.incotermString(),
                        detailsDTO.nomenclature(),
                        detailsDTO.paysOrigine(),
                        detailsDTO.designation(),
                        detailsDTO.quantite(),
                        detailsDTO.uniteComplementaire(),
                        detailsDTO.poidsUnit(),
                        detailsDTO.paysProvenance(),
                        pdfFilePaths
                );
            }
        }
        return detailsDTO;
    }
    @Override
    public void accepterTitre(Long numEnregistrement) {
      /*  TitreImportation titre = titreImportationRepository.findByIdNumeroMessage(numEnregistrement);
        String directoryName = "C:\\Users\\lenovo\\OneDrive\\Desktop\\myDesktop\\BCP_PFE\\Livrable\\Response";
        MessageReponse messageReponse = new MessageReponse(titre.getMessage().getNumeroMessage(),titre.getMessage().getEmetteur(),titre.getMessage().getDestinataire(),titre.getMessage().getDateMessage(),
                titre.getMessage().getTypeMessage(),titre.getMessage().getFonction(),
                titre.getMessage().getNumeroMessage());*/


    }
}
