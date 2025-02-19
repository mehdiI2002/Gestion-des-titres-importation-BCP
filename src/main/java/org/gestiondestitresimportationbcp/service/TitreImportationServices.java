package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.dto.TitreImportationDTO;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;

import java.util.List;

public interface TitreImportationServices {
    void insertTitle( DemandeDomiciliationMessage demandeDomiciliationMessage);
    List<TitreImportationDTO> afficherTitreImportation();
}
