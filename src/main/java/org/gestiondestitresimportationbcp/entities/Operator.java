package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Operator {
    @Id // Définit cette propriété comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient // Auto-génération de la clé primaire
    private Long id;
    @XmlElement(name = "Nom")
    private String nom;

    @XmlElement(name = "Centre")
private int centre ;
    @XmlElement(name = "TypeIdentification")
private String typeIdentification;

    @XmlElement(name = "NumIdentification")
private long numIdentification;
    @XmlElement(name = "IdentifiantDouane")
private long identifiantDouane;
    @XmlElement(name = "RibBancaire")
private long ribBancaire ;
    @XmlElement(name="IdFIscalUnique")
private long idFiscalUnique;

    public Operator() {
    }

    public Operator(Long id, String nom, int centre, String typeIdentification, long numIdentification, long identifiantDouane, long ribBancaire, long idFiscalUnique) {
        this.id = id;
        this.nom = nom;
        this.centre = centre;
        this.typeIdentification = typeIdentification;
        this.numIdentification = numIdentification;
        this.identifiantDouane = identifiantDouane;
        this.ribBancaire = ribBancaire;
        this.idFiscalUnique = idFiscalUnique;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCentre() {
        return centre;
    }

    public String getTypeIdentification() {
        return typeIdentification;
    }

    public long getNumIdentification() {
        return numIdentification;
    }

    public long getIdentifiantDouane() {
        return identifiantDouane;
    }

    public long getRibBancaire() {
        return ribBancaire;
    }

    public long getIdFiscalUnique() {
        return idFiscalUnique;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCentre(int centre) {
        this.centre = centre;
    }

    public void setTypeIdentification(String typeIdentification) {
        this.typeIdentification = typeIdentification;
    }

    public void setNumIdentification(long numIdentification) {
        this.numIdentification = numIdentification;
    }

    public void setIdentifiantDouane(long identifiantDouane) {
        this.identifiantDouane = identifiantDouane;
    }

    public void setRibBancaire(long ribBancaire) {
        this.ribBancaire = ribBancaire;
    }

    public void setIdFiscalUnique(long idFiscalUnique) {
        this.idFiscalUnique = idFiscalUnique;
    }
}
