package org.gestiondestitresimportationbcp.entities;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.models.FichierID;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Fichier {
    @EmbeddedId
    FichierID id ;
    @Transient
   @XmlElement(name = "Nom")
    private String nom ;
    @Column
   @XmlElement(name = "Description")
    private String description ;
    @Column
   @XmlElement(name = "Date")
    private Date date;
    @Transient
    @XmlElement(name = "Contenu-base64")
    private String  contenu ;

    public String getContenu() {
        return contenu;
    }

    public Fichier() {
    }

    public FichierID getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setId(FichierID id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
