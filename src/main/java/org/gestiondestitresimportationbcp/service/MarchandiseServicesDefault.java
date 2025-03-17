package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.MarchandiseInfo;
import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.repositories.MarchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarchandiseServicesDefault implements  MarhandiseServices{
    @Autowired
    MarchandiseRepository marchandiseRepository;
    @Override
    public void insertManrchandise(DemandeDomiciliationMessage demande) {
        MarchandiseInfo marchandise = demande.getMarchandise().getMarchandiseInfo();

        marchandiseRepository.save(marchandise);
    }

    @Override
    public List<MarchandiseInfo> selectMarchandise() {
        return marchandiseRepository.findAll();
    }
}
