package org.gestiondestitresimportationbcp.models;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;




@XmlAccessorType(XmlAccessType.FIELD)
public class TitreFIC {
    @XmlElement(name = "NumEnregistrement")
    private Long numEnregistrement ;
    @Column
    @XmlElement(name = "RibBancaire")
    private String ribBancaire ;


    public TitreFIC(Long numEnregistrement, String ribBancaire) {
        this.numEnregistrement = numEnregistrement;
        this.ribBancaire = ribBancaire;
    }

    public TitreFIC() {
    }

    public Long getNumEnregistrement() {
        return numEnregistrement;
    }

    public String getRibBancaire() {
        return ribBancaire;
    }




}
