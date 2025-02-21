package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class PaysProvenanceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id ;
    @XmlElement(name = "PaysProvenance")
    private String pays ;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Long getId() {
        return id;
    }

    public String getPays() {
        return pays;
    }

    public PaysProvenanceInfo(Long id, String pays) {
        this.id = id;
        this.pays = pays;
    }

    public PaysProvenanceInfo() {
    }
}
