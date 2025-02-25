package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.dto.TitreImportationDetailsDTO;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.TitreImportationId;

import java.util.List;

public interface TitreImportationServices {
    void insertTitle( DemandeDomiciliationMessage demandeDomiciliationMessage);
    List<TitreImportationDTO> afficherTitreImportation();
    TitreImportationDetailsDTO afficherDetailTitreImportation( TitreImportationId id );
}
