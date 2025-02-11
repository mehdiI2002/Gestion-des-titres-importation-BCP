package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table
public class TitreImportation  {
   @Id
   @XmlElement(name="NumEnregistrement")
   @Column(name = "NumEnregistrement")
    private Long numEnregistrement;

@Column(name = "Categorie")
   @XmlElement(name = "Categorie")
    private int Categorie;

    @Column(name = "TypeDemande")
    @XmlElement(name ="TypeDemande")
    private int typeDedmande;

@Column(name =  "Importateur")
    @XmlElement(name  = "Importateur")
    private String importateur;

@Column(name = "Expediteur")
    @XmlElement(name = "Expediteur")
    private String expediteur;

@Column(name = "RegimeDouanier")
    @XmlElement(name = "RegimeDouanier")
    private int regimeDouanier;

@Column(name = "BureauDouanier")
    @XmlElement(name = "BureauDouanier")
    private int bureauDouanier ;

@Column(name = "MontantTotal")
    @XmlElement(name = "MontantTotal")
    private double  montantTotale;

@Column(name = "MontantFOB")
    @XmlElement(name = "MontantFOB")
    private double montantFOB;

@Column(name = "MontantFret")
    @XmlElement(name="MontantFret")
    private double motantFret;

@Column(name = "MontantAssuranceAcessoires")
    @XmlElement(name = "MontantAssuranceAcessoires")
    private String montantAssuranceAcessoires;

@Column(name =  "Devise")
    @XmlElement(name = "Devise")
    private String devise;
@Column(name = "ConditionsLivraison")
    @XmlElement(name = "ConditionsLivraison")
    private int  ConditionsLivraison;

@Column(name = "Incoterm")
    @XmlElement(name = "Incoterm")
    private String incotermString;

    public TitreImportation() {
    }

    public TitreImportation(Long numEnregistrement, int categorie, int typeDedmande, String importateur, String expediteur, int regimeDouanier, int bureauDouanier, double montantTotale, double montantFOB, double motantFret, String montantAssuranceAcessoires, String devise, int conditionsLivraison, String incotermString) {
        this.numEnregistrement = numEnregistrement;
        Categorie = categorie;
        this.typeDedmande = typeDedmande;
        this.importateur = importateur;
        this.expediteur = expediteur;
        this.regimeDouanier = regimeDouanier;
        this.bureauDouanier = bureauDouanier;
        this.montantTotale = montantTotale;
        this.montantFOB = montantFOB;
        this.motantFret = motantFret;
        this.montantAssuranceAcessoires = montantAssuranceAcessoires;
        this.devise = devise;
        ConditionsLivraison = conditionsLivraison;
        this.incotermString = incotermString;
    }

    public Long getNumEnregistrement() {
        return numEnregistrement;
    }

    public int getCategorie() {
        return Categorie;
    }

    public int getTypeDedmande() {
        return typeDedmande;
    }

    public String getImportateur() {
        return importateur;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public int getRegimeDouanier() {
        return regimeDouanier;
    }

    public int getBureauDouanier() {
        return bureauDouanier;
    }

    public double getMontantTotale() {
        return montantTotale;
    }

    public double getMontantFOB() {
        return montantFOB;
    }

    public double getMotantFret() {
        return motantFret;
    }

    public String getMontantAssuranceAcessoires() {
        return montantAssuranceAcessoires;
    }

    public String getDevise() {
        return devise;
    }

    public int getConditionsLivraison() {
        return ConditionsLivraison;
    }

    public String getIncotermString() {
        return incotermString;
    }

    public void setNumEnregistrement(Long numEnregistrement) {
        this.numEnregistrement = numEnregistrement;
    }

    public void setCategorie(int categorie) {
        Categorie = categorie;
    }

    public void setTypeDedmande(int typeDedmande) {
        this.typeDedmande = typeDedmande;
    }

    public void setImportateur(String importateur) {
        this.importateur = importateur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public void setRegimeDouanier(int regimeDouanier) {
        this.regimeDouanier = regimeDouanier;
    }

    public void setBureauDouanier(int bureauDouanier) {
        this.bureauDouanier = bureauDouanier;
    }

    public void setMontantTotale(double montantTotale) {
        this.montantTotale = montantTotale;
    }

    public void setMontantFOB(double montantFOB) {
        this.montantFOB = montantFOB;
    }

    public void setMotantFret(double motantFret) {
        this.motantFret = motantFret;
    }

    public void setMontantAssuranceAcessoires(String montantAssuranceAcessoires) {
        this.montantAssuranceAcessoires = montantAssuranceAcessoires;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public void setConditionsLivraison(int conditionsLivraison) {
        ConditionsLivraison = conditionsLivraison;
    }

    public void setIncotermString(String incotermString) {
        this.incotermString = incotermString;
    }
}


