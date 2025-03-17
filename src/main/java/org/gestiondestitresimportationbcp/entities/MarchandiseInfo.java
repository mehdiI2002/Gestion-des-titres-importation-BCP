package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class MarchandiseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  marchandiseId;

    @XmlElement(name = "Nomenclature")
    private  long nomenclature;

    @Column
    @XmlElement(name = "PaysOrigine")
    private String paysOrigine;

    @Column
    @XmlElement(name = "Designation")
    private String designation ;

    @Column
    @XmlElement(name = "Quantite")
    private double quantite ;

    @Column
    @XmlElement(name = "UnitComplementaire")
    private String uniteComplementaire;

    @Column
    @XmlElement(name = "PoidNet")
    private double poidsUnit;



    public MarchandiseInfo() {
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

    public String getUniteComplementaire() {
        return uniteComplementaire;
    }

    public double getPoidsUnit() {
        return poidsUnit;
    }



    public void setNomenclature(long nomenclature) {
        this.nomenclature = nomenclature;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public void setUniteComplementaire(String uniteComplementaire) {
        this.uniteComplementaire = uniteComplementaire;
    }

    public void setPoidsUnit(double poidsUnit) {
        this.poidsUnit = poidsUnit;
    }

    public Long getMarchandiseId() {
        return marchandiseId;
    }
}
