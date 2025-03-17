package org.gestiondestitresimportationbcp.mappers;

import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.repositories.PdfFileRepository;
import org.gestiondestitresimportationbcp.service.PdfFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
@Service
public class TitreImportationDetailsDTOMapper implements Function<TitreImportation, TitreImportationDetailsDTO> {
    @Autowired
    private PdfFileServices pdfFileServices;
    @Override
    public TitreImportationDetailsDTO apply(TitreImportation titreImportation) {
        List<String> pdfFilePaths =pdfFileServices.selectPdfsFortitle(titreImportation.getId().getNumEnregistrement());

        return new TitreImportationDetailsDTO(
                ///message
                titreImportation.getMessage().getNumeroMessage(),
                titreImportation.getMessage().getEmetteur(),
                titreImportation.getMessage().getDestinataire(),
                titreImportation.getMessage().getDateMessage(),
                titreImportation.getMessage().getTypeMessage(),
                titreImportation.getMessage().getFonction(),
                ///operator
                titreImportation.getOperator().getIdFiscalUnique(),
                titreImportation.getOperator().getNom(),
                titreImportation.getOperator().getCentre(),
                titreImportation.getOperator().getTypeIdentification(),
                titreImportation.getOperator().getId().getNumIdentification(),
                titreImportation.getOperator().getIdentifiantDouane(),
                titreImportation.getOperator().getRibBancaire(),
                //Banque
                titreImportation.getBanque().getIdBanque().getCodeBank(),
                titreImportation.getBanque().getGuichet(),
                titreImportation.getBanque().getLocalite(),
                //title importatio
                titreImportation.getId().getNumEnregistrement(),
                titreImportation.getCategorie(),
                titreImportation.getTypeDedmande(),
                titreImportation.getImportateur(),
                titreImportation.getExpediteur(),
                titreImportation.getRegimeDouanier(),
                titreImportation.getBureauDouanier(),
                titreImportation.getMontantTotale(),
                titreImportation.getMontantFOB(),
                titreImportation.getMotantFret(),
                titreImportation.getMontantAssuranceAcessoires(),
                titreImportation.getDevise(),
                titreImportation.getConditionsLivraison(),
                titreImportation.getIncotermString(),
                //marchandise
                titreImportation.getMarchandiseInfo().getNomenclature(),
                titreImportation.getMarchandiseInfo().getPaysOrigine(),
                titreImportation.getMarchandiseInfo().getDesignation(),
                titreImportation.getMarchandiseInfo().getQuantite(),
                titreImportation.getMarchandiseInfo().getUniteComplementaire(),
                titreImportation.getMarchandiseInfo().getPoidsUnit(),
                ///paysperovenance
                titreImportation.getPaysProvenanceInfo().getPays(),
                pdfFilePaths



        );
    }
}
