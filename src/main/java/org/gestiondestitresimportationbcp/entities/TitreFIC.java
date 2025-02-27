package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.models.TitreFICId;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class TitreFIC {
    @EmbeddedId
    private TitreFICId titreFICId;
    @Transient
    @XmlElement(name = "NumEnregistrement")
    private Long numEnregistrement ;
    @Column
    @XmlElement(name = "RibBancaire")
    private String ribBancaire ;

    public TitreFIC(TitreFICId titreFICId, Long numEnregistrement, String ribBancaire) {
        this.titreFICId = titreFICId;
        this.numEnregistrement = numEnregistrement;
        this.ribBancaire = ribBancaire;
    }

    public TitreFIC() {
    }

    public Long getNumEnregistrement() {
        return numEnregistrement;
    }

    public String getRibBancaire() {
        return ribBancaire;
    }

    public void setTitreFICId(TitreFICId titreFICId) {
        this.titreFICId = titreFICId;
    }
}
