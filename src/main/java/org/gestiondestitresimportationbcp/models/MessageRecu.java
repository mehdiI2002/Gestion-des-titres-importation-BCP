package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)

public class MessageRecu {
    @XmlElement(name = "ReferenceEmetteur")
    private long referenceEmetteur;
    @XmlElement(name = "TypeMessage")
    private String typeMessage;
    @XmlElement(name = "Fonction")
    private int fonction ;
    @XmlElement(name = "Date")
    private Date date ;

    public MessageRecu(long referenceEmetteur, String typeMessage, int fonction, Date date) {
        this.referenceEmetteur = referenceEmetteur;
        this.typeMessage = typeMessage;
        this.fonction = fonction;
        this.date = date;
    }

    public MessageRecu() {
    }
}
