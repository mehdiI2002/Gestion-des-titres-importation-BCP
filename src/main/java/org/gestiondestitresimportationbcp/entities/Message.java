package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)

public class Message {
    @Id
    @Column(name = "NumeroMessage")
    @XmlElement(name = "NumeroMessage")
    private Long numeroMessage;

    @Column(name = "Emetteur")
    @XmlElement(name = "Emetteur")
    private String emetteur;


    @Column(name = "Destinataire")
    @XmlElement(name = "Destinataire")
    private int destinataire;

    @Column(name = "DateDeMessage")
    @XmlElement(name = "DateMessage")
    private Date dateMessage; // il faut qu il soit date
    @Column(name = "TypeDeMessage")
    private String typeMessage;


    @Column(name = "Fonction")
    @XmlElement(name = "Fonction")
    private String fonction;

    public Message(Long numeroMessage, String emetteur, int destinataire, Date dateMessage, String typeMessage, String fonction) {
        this.numeroMessage = numeroMessage;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.dateMessage = dateMessage;
        this.typeMessage = typeMessage;
        this.fonction = fonction;
    }

    public Message() {
    }

    public Long getNumeroMessage() {
        return numeroMessage;
    }

    public String getEmetteur() {
        return emetteur;
    }

    public int getDestinataire() {
        return destinataire;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public String getFonction() {
        return fonction;
    }
}
