package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class TitreReponse {
    @XmlElement(name = "NumEnregistrement")
    private Long numEnregistrement;
    public TitreReponse() {
    }

    public TitreReponse(Long numEnregistrement) {
        this.numEnregistrement = numEnregistrement;
    }

    public Long getNumEnregistrement() {
        return numEnregistrement;
    }
}
