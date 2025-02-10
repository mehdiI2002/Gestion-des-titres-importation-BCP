package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {
    @Id
    @Column(name = "NumeroMessage")
    @XmlElement(name = "NumeroMessage")
    private Long numeroMessage;

    @Column(name = "Emetteur")
    @XmlElement(name = "Emetteur")
    private String emetteur;


    @Column(name = "Destinataire")
    @XmlElement(name = "Destinataire")
    private int destinataire;

    @Column(name = "DateDeMessage")
    @XmlElement(name = "DateMessage")
    private Date dateMessage;
    @XmlElement(name = "TypeMessage")// il faut qu il soit date
    @Column(name = "TypeDeMessage")
    private String typeMessage;


    @Column(name = "Fonction")
    @XmlElement(name = "Fonction")
    private String fonction;



}
