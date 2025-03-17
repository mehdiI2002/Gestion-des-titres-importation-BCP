package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class ReponseAcceptation  {
    @XmlElement(name = "Etat")
    private int etat ;

    @XmlElement(name = "NumDomiciliation")
    private Long numDomiciliation;
@XmlElement(name = "DateAcceptation")
    private Date dateAcceptation ;
@XmlElement(name = "DateExpiration")
private Date dateExpiration;
@XmlElement
private String motifRefus;




    public ReponseAcceptation(int etat, Date dateAcceptation) {
        this.etat = etat;
        this.dateAcceptation = dateAcceptation;
    }


    public ReponseAcceptation(int etat, long numDomiciliation, Date dateAcceptation, Date dateExpiration) {
        this.etat = etat;
        this.numDomiciliation = numDomiciliation;
        this.dateAcceptation = dateAcceptation;
        this.dateExpiration = dateExpiration;
    }



    public ReponseAcceptation(int etat, String motifRefus) {
        this.etat = etat;
        this.motifRefus = motifRefus;
    }

    public int getEtat() {
        return etat;
    }

    public long getNumDomiciliation() {
        return numDomiciliation;
    }

    public Date getDateAcceptation() {
        return dateAcceptation;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public String getMotifRefus() {
        return motifRefus;
    }
}
