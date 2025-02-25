package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Banque;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;

import java.util.List;

public interface BanqueServices {
    void insertBank(DemandeDomiciliationMessage demandeDomiciliationMessage);
    List<Banque> selectBanks();

}
