package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.entities.Fichier;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class FichierInfo {
    @XmlElement(name = "Fichier")
    private List<Fichier> fichiers;

    public FichierInfo() {
    }

    public List<Fichier> getFichiers() {
        return fichiers;
    }

    public FichierInfo(List<Fichier> fichiers) {
        this.fichiers = fichiers;
    }
}
