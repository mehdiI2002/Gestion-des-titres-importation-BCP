package org.gestiondestitresimportationbcp.mappers;

import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class TitreImportationDetailsDTOMapper implements Function<TitreImportation, TitreImportationDetailsDTO> {
    @Override
    public TitreImportationDetailsDTO apply(TitreImportation titreImportation) {
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
                titreImportation.getOperator().getNumIdentification(),
                titreImportation.getOperator().getIdentifiantDouane(),
                titreImportation.getOperator().getRibBancaire(),
                //Banque
                titreImportation.getBanque().getCodeBanque(),
                titreImportation.getBanque().getGuichet(),
                titreImportation.getBanque().getLocalite(),
                //title importation
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
                titreImportation.getPaysProvenanceInfo().getPays()
        );
    }
}
