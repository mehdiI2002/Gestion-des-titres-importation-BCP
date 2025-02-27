package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)

public class Message {
    @Id
    @Column(name = "Numero_Message")
    @XmlElement(name = "NumeroMessage")
    private Long numeroMessage;


    @Column(name = "Emetteur")
    @XmlElement(name = "Emetteur")
    private String emetteur;



    @Column(name = "Destinataire")
    @XmlElement(name = "Destinataire")
    private int destinataire;

    @Column(name = "Date_de_Message")
    @XmlElement(name = "DateMessage")
    private Date dateMessage;
    @XmlElement(name = "TypeMessage")
    @Column(name = "Type_De_Message")
    private String typeMessage;


    @Column(name = "Fonction")
    @XmlElement(name = "Fonction")
    private String fonction;
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

    public Message(Long numeroMessage, String emetteur, int destinataire, Date dateMessage, String typeMessage, String fonction) {
        this.numeroMessage = numeroMessage;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.dateMessage = dateMessage;
        this.typeMessage = typeMessage;
        this.fonction = fonction;
    }

    public void setNumeroMessage(Long numeroMessage) {
        this.numeroMessage = numeroMessage;
    }

    public void setEmetteur(String emetteur) {
        this.emetteur = emetteur;
    }

    public void setDestinataire(int destinataire) {
        this.destinataire = destinataire;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}
