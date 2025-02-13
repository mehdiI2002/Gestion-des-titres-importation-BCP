package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.entities.MarchandiseInfo;


@XmlAccessorType(XmlAccessType.FIELD)
public class Marchandise {
    @XmlElement(name = "MarchandiseInfo")
    private MarchandiseInfo marchandiseInfo;

    public Marchandise(MarchandiseInfo marchandiseInfo) {
        this.marchandiseInfo = marchandiseInfo;
    }

    public MarchandiseInfo getMarchandiseInfo() {
        return marchandiseInfo;
    }

    public Marchandise() {
    }
}
