package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class BanqueRep {
    @XmlElement(name = "CodeBanque")
    private Long codeBanque;
    @XmlElement(name = "Guichet")
    private long guichet;
    @XmlElement(name = "Localite")
    private long localite;
    @XmlElement(name = "RibBancaire")
    private String ribBancaire ;

    public BanqueRep() {
    }

    public Long getCodeBanque() {
        return codeBanque;
    }

    public BanqueRep(Long codeBanque, long guichet, long localite, String ribBancaire) {
        this.codeBanque = codeBanque;
        this.guichet = guichet;
        this.localite = localite;
        this.ribBancaire = ribBancaire;
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

}
