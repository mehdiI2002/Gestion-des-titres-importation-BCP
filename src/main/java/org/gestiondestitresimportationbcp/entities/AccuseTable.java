package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class AccuseTable {
    @Id
   private  Long numeroMessage ;
    @Column
    private String emetteur;
    @Column
    private String destinataire;
    @Column
    private Date dateMessage;
    @Column
    private String typeMessage;
    @Column
    private String fonctionMessage;
    @Column
    private long referenceEmetteurMessageRecu;
    @Column
    private String typeMessageRecu;
    @Column
    private int fonctionMessageRecu ;
    @Column
    private Date dateMessageRecu ;
    @Column
    private String code ;
    @Column
    private String description ;

    public AccuseTable() {
    }

    public AccuseTable(Long numeroMessage, String emetteur, String destinataire, Date dateMessage, String typeMessage, String fonctionMessage, long referenceEmetteurMessageRecu, String typeMessageRecu, int fonctionMessageRecu, Date dateMessageRecu, String code, String description) {
        this.numeroMessage = numeroMessage;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.dateMessage = dateMessage;
        this.typeMessage = typeMessage;
        this.fonctionMessage = fonctionMessage;
        this.referenceEmetteurMessageRecu = referenceEmetteurMessageRecu;
        this.typeMessageRecu = typeMessageRecu;
        this.fonctionMessageRecu = fonctionMessageRecu;
        this.dateMessageRecu = dateMessageRecu;
        this.code = code;
        this.description = description;
    }

    public Long getNumeroMessage() {
        return numeroMessage;
    }

    public String getEmetteur() {
        return emetteur;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public String getFonctionMessage() {
        return fonctionMessage;
    }

    public long getReferenceEmetteurMessageRecu() {
        return referenceEmetteurMessageRecu;
    }

    public int getFonctionMessageRecu() {
        return fonctionMessageRecu;
    }

    public String getTypeMessageRecu() {
        return typeMessageRecu;
    }

    public Date getDateMessageRecu() {
        return dateMessageRecu;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
