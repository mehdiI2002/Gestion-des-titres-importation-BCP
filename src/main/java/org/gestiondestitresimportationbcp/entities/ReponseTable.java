package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class ReponseTable {
    @Id
    private Long numeroMessage;
    @Column
    private String emetteur;
   @Column
    private String destinataire;//elle a ete int
 @Column
    private Date dateMessage;
 @Column
    private String typeMessage;
 @Column
    private String fonction;
  @Column
    private Long referenceEmetteur;
  @Column
    private Long codeBanque;
   @Column
    private long guichet;
    @Column
    private long localite;
  @Column
    private String ribBancaire ;
  @Column
    private Long numEnregistrement;
  @Column
  String motif;

    public ReponseTable() {
    }

    public ReponseTable(Long numeroMessage, String emetteur, String destinataire, Date dateMessage, String typeMessage, String fonction, Long referenceEmetteur, Long codeBanque, long guichet, long localite, String ribBancaire, Long numEnregistrement, String motif) {
        this.numeroMessage = numeroMessage;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.dateMessage = dateMessage;
        this.typeMessage = typeMessage;
        this.fonction = fonction;
        this.referenceEmetteur = referenceEmetteur;
        this.codeBanque = codeBanque;
        this.guichet = guichet;
        this.localite = localite;
        this.ribBancaire = ribBancaire;
        this.numEnregistrement = numEnregistrement;
        this.motif = motif;
    }
    public ReponseTable(Long numeroMessage, String emetteur, String destinataire, Date dateMessage, String typeMessage, String fonction, Long referenceEmetteur, Long codeBanque, long guichet, long localite, String ribBancaire, Long numEnregistrement) {
        this.numeroMessage = numeroMessage;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.dateMessage = dateMessage;
        this.typeMessage = typeMessage;
        this.fonction = fonction;
        this.referenceEmetteur = referenceEmetteur;
        this.codeBanque = codeBanque;
        this.guichet = guichet;
        this.localite = localite;
        this.ribBancaire = ribBancaire;
        this.numEnregistrement = numEnregistrement;

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

    public Long getReferenceEmetteur() {
        return referenceEmetteur;
    }

    public Long getCodeBanque() {
        return codeBanque;
    }

    public long getGuichet() {
        return guichet;
    }

    public long getLocalite() {
        return localite;
    }

    public String getRibBancaire() {
        return ribBancaire;
    }

    public Long getNumEnregistrement() {
        return numEnregistrement;
    }

    public String getMotif() {
        return motif;
    }
}
