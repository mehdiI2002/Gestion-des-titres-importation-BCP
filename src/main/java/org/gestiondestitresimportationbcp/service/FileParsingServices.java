package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.gestiondestitresimportationbcp.models.FichiersTitreBanqueMessage;

import java.io.File;

public interface FileParsingServices {
    DemandeDomiciliationMessage parseFile(File file);

     FichiersTitreBanqueMessage parseFICFIle( File file );

}
