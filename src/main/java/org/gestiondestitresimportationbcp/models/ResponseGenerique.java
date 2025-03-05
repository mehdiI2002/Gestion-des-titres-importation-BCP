package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReponseGenerique", namespace = "http://portnet.ma/ReponseGenerique")
public class ResponseGenerique {

   @XmlElement(name = "ReponseGeneriqueMessage")
   ResponseGeneriqueMessage reponseGeneriqueMessage;

    public ResponseGenerique() {
    }

    public ResponseGenerique(ResponseGeneriqueMessage reponseGeneriqueMessage) {
        this.reponseGeneriqueMessage = reponseGeneriqueMessage;
    }
}
