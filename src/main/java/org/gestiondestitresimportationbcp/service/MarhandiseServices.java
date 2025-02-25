package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.MarchandiseInfo;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;

import java.util.List;

public interface MarhandiseServices {
    public void insertManrchandise(DemandeDomiciliationMessage demande);
    public List<MarchandiseInfo> selectMarchandise();
}
