package org.gestiondestitresimportationbcp.entities;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Banque {

    @Id
    @Column(name = "Code_Banque")
    @XmlElement(name = "CodeBanque")
    private Long codeBanque;
    @Column(name = "Guichet")
    @XmlElement(name = "Guichet")
    private long guichet;

    @Column(name = "Localite")
    @XmlElement(name = "Localite")
    private long localite;

    public Banque() {
    }

    public Banque(Long codeBanque, long guichet, long localite) {

        this.codeBanque = codeBanque;
        this.guichet = guichet;
        this.localite = localite;
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



    public void setCodeBanque(Long codeBanque) {
        this.codeBanque = codeBanque;
    }

    public void setGuichet(long guichet) {
        this.guichet = guichet;
    }

    public void setLocalite(long localite) {
        this.localite = localite;
    }
}
