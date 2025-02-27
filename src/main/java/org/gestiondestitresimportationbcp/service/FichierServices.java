package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;

public interface FichierServices {
    void insertFile(FichiersTitreBanqueMessage fichiers);
    void decode(FichiersTitreBanqueMessage fichiersMessage);
}
