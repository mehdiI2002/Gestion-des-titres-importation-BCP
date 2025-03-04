package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.entities.Message;

@XmlAccessorType(XmlAccessType.FIELD)
public class FichiersTitreBanqueMessage {

    @XmlElement(name = "Titre")
    private TitreFIC titreFIC;
    @XmlElement(name = "HeaderMessage")
    private Message message ;

    @XmlElement(name = "FichierInfo", namespace = "http://portnet.ma/FichiersTitreBanque")
    private FichierInfo fichierInfo;

    public Message getMessage() {
        return message;
    }

    public TitreFIC getTitreFIC() {
        return titreFIC;
    }

    public FichierInfo getFichierInfo() {
        return fichierInfo;
    }

    public FichiersTitreBanqueMessage() {
    }


}
