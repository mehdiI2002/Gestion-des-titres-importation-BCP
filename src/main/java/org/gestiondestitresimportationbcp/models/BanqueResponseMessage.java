package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class BanqueResponseMessage {
    @XmlElement(name = "HeaderMessage")
    private MessageReponse headerMessageReponse;
    @XmlElement(name = "Banque")
    private BanqueRep banqueRep;
    @XmlElement(name ="Titre")
    private TitreReponse titreReponse;
    @XmlElement(name = "Reponse")
    private ReponseAcceptation reponse;

    public BanqueResponseMessage() {
    }

    public BanqueResponseMessage(MessageReponse headerMessageReponse, BanqueRep banqueRep, TitreReponse titreReponse, ReponseAcceptation reponse) {
        this.headerMessageReponse = headerMessageReponse;
        this.banqueRep = banqueRep;
        this.titreReponse = titreReponse;
        this.reponse = reponse;
    }

    public MessageReponse getHeaderMessageReponse() {
        return headerMessageReponse;
    }

    public BanqueRep getBanqueRep() {
        return banqueRep;
    }

    public TitreReponse getTitreReponse() {
        return titreReponse;
    }

    public ReponseAcceptation getReponse() {
        return reponse;
    }
}
