package org.gestiondestitresimportationbcp.mappers;

import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
    public class TitreImportationDTOMapper implements Function<TitreImportation, TitreImportationDTO> {
    @Override
    public TitreImportationDTO apply(TitreImportation titreImportation) {
       return  new TitreImportationDTO(
                titreImportation.getNumEnregistrement(),
                titreImportation.getCategorie(),
                titreImportation.getMontantTotale(),
                titreImportation.getMontantFOB(),
                titreImportation.getMotantFret(),
                titreImportation.getDevise(),
                titreImportation.getIncotermString(),
                titreImportation.getOperator().getRibBancaire()
        );
    }
}
