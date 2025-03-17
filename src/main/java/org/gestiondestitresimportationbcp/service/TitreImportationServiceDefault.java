package org.gestiondestitresimportationbcp.service;
import jakarta.transaction.Transactional;
import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.entities.Operator;

import org.gestiondestitresimportationbcp.entities.PaysProvenanceInfo;
import org.gestiondestitresimportationbcp.entities.ReponseTable;
import org.gestiondestitresimportationbcp.mappers.TitreImportationDTOMapper;
import org.gestiondestitresimportationbcp.mappers.TitreImportationDetailsDTOMapper;
import org.gestiondestitresimportationbcp.models.*;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.repositories.PaysProvenanceInfoRepository;
import org.gestiondestitresimportationbcp.repositories.ResponseTablerepository;
import org.gestiondestitresimportationbcp.repositories.TitreImportationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    @Autowired
    TransformObjectsToResponeFile transformObjectsToResponeFile;
    private  static int cpt = 0 ;
    private BanqueResponseMessage message ;
    @Autowired
    private ResponseTablerepository responseTablerepository;

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
        return titreImportationRepository.findNonTraites()
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
    public void accepterTitre(Long numeroMessage) {
        TitreImportation titre = titreImportationRepository.findByIdNumeroMessage(numeroMessage);
        Long messageId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            MessageReponse messageReponse = new MessageReponse(messageId, titre.getMessage().getEmetteur(), titre.getMessage().getDestinataire(), titre.getMessage().getDateMessage(),
                    titre.getMessage().getTypeMessage(), titre.getMessage().getFonction(),
                    titre.getMessage().getNumeroMessage());
            BanqueRep banqueRep = new BanqueRep(titre.getBanque().getIdBanque().getCodeBank(), titre.getBanque().getGuichet(), titre.getBanque().getLocalite(), titre.getOperator().getRibBancaire());
        TitreReponse titreReponse = new TitreReponse(titre.getId().getNumEnregistrement());

        if(titre.getMessage().getTypeMessage().contains("DDD")) {
            Long numDomiciliation = titre.getBanque().getGuichet()  + cpt++;
            Date dateActuelle = new Date(); // Date actuelle
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateActuelle);
            calendar.add(Calendar.MONTH, 3); // Ajoute 3 mois
            Date datePlus3Mois = calendar.getTime();
            ReponseAcceptation reponse = new ReponseAcceptation(1,numDomiciliation,dateActuelle,datePlus3Mois);
            message = new BanqueResponseMessage(messageReponse, banqueRep, titreReponse,reponse);
        }
        else if(titre.getMessage().getTypeMessage().contains("DPD")){
   ReponseAcceptation reponseDPD = new ReponseAcceptation(1,new Date());
   message= new BanqueResponseMessage(messageReponse,banqueRep,titreReponse,reponseDPD);
        }
        titre.setEtat("traite");
        titreImportationRepository.save(titre);
        transformObjectsToResponeFile.tranformReponseToXml(message);
        ReponseTable reponseTable = new ReponseTable(messageId,titre.getMessage().getEmetteur(), titre.getMessage().getDestinataire(), titre.getMessage().getDateMessage(),
                titre.getMessage().getTypeMessage(),titre.getMessage().getFonction(),titre.getMessage().getNumeroMessage()
                ,titre.getBanque().getIdBanque().getCodeBank(), titre.getBanque().getGuichet(), titre.getBanque().getLocalite(), titre.getOperator().getRibBancaire(),
                titre.getId().getNumEnregistrement());
        responseTablerepository.save(reponseTable);
    }

    @Override
    public void refuserTitre(Long numeroMessage,String motif) {
        long messageId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        BanqueResponseMessage message;
        TitreImportation titre = titreImportationRepository.findByIdNumeroMessage(numeroMessage);
        MessageReponse messageReponse = new MessageReponse(messageId, titre.getMessage().getEmetteur(), titre.getMessage().getDestinataire(), titre.getMessage().getDateMessage(),
                titre.getMessage().getTypeMessage(), titre.getMessage().getFonction(),
                titre.getMessage().getNumeroMessage());
        BanqueRep banqueRep = new BanqueRep(titre.getBanque().getIdBanque().getCodeBank(), titre.getBanque().getGuichet(), titre.getBanque().getLocalite(), titre.getOperator().getRibBancaire());
        TitreReponse titreReponse = new TitreReponse(titre.getId().getNumEnregistrement());
       ReponseAcceptation reponse = new ReponseAcceptation(2,motif);
        message= new BanqueResponseMessage(messageReponse,banqueRep,titreReponse,reponse);
        titre.setEtat("traite");
        titreImportationRepository.save(titre);
        transformObjectsToResponeFile.tranformReponseToXml(message);
        ReponseTable reponseTable = new ReponseTable(messageId,titre.getMessage().getEmetteur(), titre.getMessage().getDestinataire(), titre.getMessage().getDateMessage(),
                titre.getMessage().getTypeMessage(),titre.getMessage().getFonction(),titre.getMessage().getNumeroMessage()
        ,titre.getBanque().getIdBanque().getCodeBank(), titre.getBanque().getGuichet(), titre.getBanque().getLocalite(), titre.getOperator().getRibBancaire(),
                titre.getId().getNumEnregistrement(),motif  );
        responseTablerepository.save(reponseTable);
    }
}
