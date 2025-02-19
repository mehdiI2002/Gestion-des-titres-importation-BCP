package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.entities.PaysProvenance;

@XmlAccessorType(XmlAccessType.FIELD)

public class PaysProvenanceInfo {
    @XmlElement(name = "PaysProvenance")
    private PaysProvenance paysProvenance;

    public PaysProvenanceInfo(PaysProvenance paysProvenance) {
        this.paysProvenance = paysProvenance;
    }

    public PaysProvenance getPaysProvenance() {
        return paysProvenance;
    }

    public PaysProvenanceInfo() {
    }


}
