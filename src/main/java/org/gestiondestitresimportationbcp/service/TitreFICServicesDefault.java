package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.TitreFIC;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;
import org.gestiondestitresimportationbcp.models.TitreFICId;
import org.gestiondestitresimportationbcp.repositories.TitreFICRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitreFICServicesDefault implements  TitreFICServices{
    @Autowired
     TitreFICRepository titreFICRepository;
    @Override
    public void insertTitreFIC(FichiersTitreBanqueMessage fichiers) {
        TitreFICId id = new TitreFICId(fichiers.getTitreFIC().getNumEnregistrement(), fichiers.getMessage().getNumeroMessage());
        TitreFIC titre = fichiers.getTitreFIC();
        titre.setTitreFICId(id);
        titreFICRepository.save(titre);

    }
}
