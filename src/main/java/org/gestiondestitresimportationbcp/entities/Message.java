package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Message {
    @Id
    private Long numeroMessage;
    private String emetteur;
    private  int destinataire;
    private String dateMessage;// il faut qu il soit date
    private String typeMessage;
    private String fonction ;

    public Message() {

    }
    public Message(Long numeroMessage, String emetteur, int destinataire, String dateMessage, String typeMessage, String fonction) {
        this.numeroMessage = numeroMessage;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.dateMessage = dateMessage;
        this.typeMessage = typeMessage;
        this.fonction = fonction;
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

    public String getDateMessage() {
        return dateMessage;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public String getFonction() {
        return fonction;
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

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }


}
