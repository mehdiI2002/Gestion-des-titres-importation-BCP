package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import org.gestiondestitresimportationbcp.entities.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class DemandeDomiciliationMessage {

    @XmlElement(name = "HeaderMessage")
    private Message headerMessage;

   @XmlElement(name = "Operateur")
    private Operator operateur;

    @XmlElement(name = "Titre")
    private TitreImportation titre;

    @XmlElement(name = "Banque")
    private Banque banque;
    // Cet élément est défini avec le préfixe pn, donc il faut préciser le namespace
    @XmlElement(name = "Marchandise", namespace = "http://portnet.ma/DemandeDomiciliation")
    private Marchandise marchandise;

    public DemandeDomiciliationMessage(Message headerMessage, Operator operateur, TitreImportation titre, Banque banque, Marchandise marchandise) {
        this.headerMessage = headerMessage;
        this.operateur = operateur;
        this.titre = titre;
        this.banque = banque;
        this.marchandise = marchandise;
    }

    public Message getHeaderMessage() {
        return headerMessage;
    }

    public Operator getOperateur() {
        return operateur;
    }

    public TitreImportation getTitre() {
        return titre;
    }

    public Banque getBanque() {
        return banque;
    }

    public Marchandise getMarchandise() {
        return marchandise;
    }

    public DemandeDomiciliationMessage() {
    }
}

