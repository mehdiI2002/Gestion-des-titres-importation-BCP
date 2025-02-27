package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FichiersTitreBanque", namespace = "http://portnet.ma/FichiersTitreBanque")
public class FichiersTitreBanque {
    @XmlElement(name = "FichiersTitreBanqueMessage")
    private FichiersTitreBanqueMessage fichiersTitreBanqueMessage;

    public FichiersTitreBanque(FichiersTitreBanqueMessage fichiersTitreBanqueMessage) {
        this.fichiersTitreBanqueMessage = fichiersTitreBanqueMessage;
    }
    public FichiersTitreBanqueMessage getFichiersTitreBanqueMessage() {
        return fichiersTitreBanqueMessage;
    }
    public FichiersTitreBanque() {
    }
}
