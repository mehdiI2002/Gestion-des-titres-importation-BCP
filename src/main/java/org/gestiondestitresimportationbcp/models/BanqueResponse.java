package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BanqueReponse", namespace = "http://portnet.ma/BanqueReponse")
public class BanqueResponse {
    @XmlElement(name = "BanqueReponseMessage")
    BanqueResponseMessage banqueResponseMessage;

    public BanqueResponse() {
    }

    public BanqueResponse(BanqueResponseMessage banqueResponseMessage) {
        this.banqueResponseMessage = banqueResponseMessage;
    }

    public BanqueResponseMessage getBanqueResponseMessage() {
        return banqueResponseMessage;
    }
}
