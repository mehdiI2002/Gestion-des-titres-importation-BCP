package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Operator {
    @Id
    @XmlElement(name="IdFiscalUnique")
    private long idFiscalUnique;
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
private BigInteger ribBancaire ;






}
