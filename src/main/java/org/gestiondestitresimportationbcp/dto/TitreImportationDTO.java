package org.gestiondestitresimportationbcp.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


public record TitreImportationDTO(
        @JsonSerialize(using = ToStringSerializer.class)
        Long numEnregistrement,
        Long numeromessage,
        int categorie,
        double montantTotale,
        double montantFOB,
        double motantFret,
        String devise,
        String incotermString,
        String ribBancaire,
        String typeMessage
) {}