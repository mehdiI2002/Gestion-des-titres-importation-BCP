package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.TitreImportation;

import java.util.List;

public interface TitreImportationServices {
    void insertTitle();
    List<TitreImportation> afficherTitreImportation();
}
