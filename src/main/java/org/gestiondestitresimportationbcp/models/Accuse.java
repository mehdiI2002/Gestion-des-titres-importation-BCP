package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class Accuse {
    @XmlElement(name = "Code")
    private String Code;
    @XmlElement(name = "Description")
    private String description ;

    public String getCode() {
        return Code;
    }

    public String getDescription() {
        return description;
    }

    public Accuse(String code, String description) {
        Code = code;
        this.description = description;
    }

    public Accuse() {
    }
}
