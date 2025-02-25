package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;

import java.io.File;

public interface FileServices {
    DemandeDomiciliationMessage parseFile(File file);
     void fileswatcher();
}
