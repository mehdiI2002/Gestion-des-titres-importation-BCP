package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
@Entity
@XmlAccessorType(XmlAccessType.FIELD)

public class MarchandiseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id ;
    @Column(name = "Nomenclature")
    @XmlElement(name = "Nomenclature")
    private  long nomenclature;

    @Column(name = "PaysOrigine")
    @XmlElement(name = "PaysOrigine")
    private String paysOrigine;


    @Column(name = "Designation")
    @XmlElement(name = "Designation")
    private String designation ;


    @Column(name = "Quantite")
    @XmlElement(name = "Quantite")
    private double quantite ;

    @Column(name = "UnitComplementaire")
    @XmlElement(name = "UnitComplementaire")
    private int uniteComplementaire;

    @Column(name = "PoidNet")
    @XmlElement(name = "PoidNet")
    private double poidsUnit;

    public MarchandiseInfo(Long id, long nomenclature, String paysOrigine, String designation, double quantite, int uniteComplementaire, double poidsUnit) {
        this.id = id;
        this.nomenclature = nomenclature;
        this.paysOrigine = paysOrigine;
        this.designation = designation;
        this.quantite = quantite;
        this.uniteComplementaire = uniteComplementaire;
        this.poidsUnit = poidsUnit;
    }

    public MarchandiseInfo() {
    }

    public Long getId() {
        return id;
    }

    public long getNomenclature() {
        return nomenclature;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public String getDesignation() {
        return designation;
    }

    public double getQuantite() {
        return quantite;
    }

    public int getUniteComplementaire() {
        return uniteComplementaire;
    }

    public double getPoidsUnit() {
        return poidsUnit;
    }
}
