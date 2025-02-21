package org.gestiondestitresimportationbcp.dto;


public record TitreImportationDTO(
        Long numEnregistrement,
        int categorie,
        double montantTotale,
        double montantFOB,
        double motantFret,
        String devise,
        String incotermString,
        String ribBancaire
) {}