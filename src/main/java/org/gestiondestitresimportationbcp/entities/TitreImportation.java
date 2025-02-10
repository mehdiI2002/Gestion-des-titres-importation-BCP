package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "TitreImportation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private String incoterm;




}
