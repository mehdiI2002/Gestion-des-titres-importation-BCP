package org.gestiondestitresimportationbcp.models;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Date;
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageReponse {
    @XmlElement(name = "NumeroMessage")
    private Long numeroMessage;
    @XmlElement(name = "Emetteur")
    private String emetteur;
    @XmlElement(name = "Destinataire")
    private String destinataire;//elle a ete int
    @XmlElement(name = "DateMessage")
    private Date dateMessage;
    @XmlElement(name = "TypeMessage")
    private String typeMessage;
    @XmlElement(name = "Fonction")
    private String fonction;
    @XmlElement(name = "ReferenceEmetteur")
    private Long referenceEmetteur;

    public MessageReponse() {
    }

    public MessageReponse(Long numeroMessage, String emetteur, String destinataire, Date dateMessage, String typeMessage, String fonction, Long referenceEmetteur) {
        this.numeroMessage = numeroMessage;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.dateMessage = dateMessage;
        this.typeMessage = typeMessage;
        this.fonction = fonction;
        this.referenceEmetteur = referenceEmetteur;
    }

    public Long getNumeroMessage() {
        return numeroMessage;
    }

    public String getEmetteur() {
        return emetteur;
    }

    public String getDestinataire() {
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

    public Long  getReferenceEmetteur() {
        return referenceEmetteur;
    }
}
