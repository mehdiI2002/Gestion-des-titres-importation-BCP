package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.PaysProvenanceInfo;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;

public interface PaysProvenanceServices {
 void insertPaysProvenanceInfo(DemandeDomiciliationMessage demande);
}
