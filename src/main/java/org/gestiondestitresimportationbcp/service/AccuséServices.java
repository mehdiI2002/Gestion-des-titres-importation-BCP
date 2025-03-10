package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;

import java.io.File;

public interface AccuséServices {
    public boolean generateAccucesDDDAndDPD(File file, DemandeDomiciliationMessage demande);
   boolean generateAccusesFIC(File file ,FichiersTitreBanqueMessage fichier );

}
