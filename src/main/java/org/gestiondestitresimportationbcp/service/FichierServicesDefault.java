package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Fichier;
import org.gestiondestitresimportationbcp.models.FichierID;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;
import org.gestiondestitresimportationbcp.repositories.FichierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FichierServicesDefault implements  FichierServices{
    @Override
    public void decode(FichiersTitreBanqueMessage fichiersMessage) {
        List<Fichier> fichiers = fichiersMessage.getFichierInfo().getFichiers();
    }

    @Autowired
    FichierRepository fichierRepository;
    @Override
    public void insertFile(FichiersTitreBanqueMessage fichiersMessage) {
        List<Fichier> fichiers = fichiersMessage.getFichierInfo().getFichiers();
        for( Fichier fichier : fichiers) {      
            FichierID id = new FichierID(fichiersMessage.getMessage().getNumeroMessage(), fichier.getNom());
            fichier.setId(id);
            fichierRepository.save(fichier);
        }
    }
}
