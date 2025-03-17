package org.gestiondestitresimportationbcp.entities;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.models.BanqueId;

import java.util.ArrayList;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Banque {
    @EmbeddedId
    private BanqueId idBanque;
    @Transient
    @Column(name = "Code_Banque")
    @XmlElement(name = "CodeBanque")
    private Long codeBanque;
    @Column(name = "Guichet")
    @XmlElement(name = "Guichet")
    private long guichet;

    @Column(name = "Localite")
    @XmlElement(name = "Localite")
    private long localite;
@OneToMany(mappedBy = "banque")
private List<TitreImportation> titreImportations;

    public Banque() {
        this.titreImportations = new ArrayList<>();
    }

    public Long getCodeBanque() {
        return codeBanque;
    }

    public long getGuichet() {
        return guichet;
    }

    public long getLocalite() {
        return localite;
    }


    public List<TitreImportation> getTitreImportations() {
        return titreImportations;
    }

    public BanqueId getIdBanque() {
        return idBanque;
    }

    public void setIdBanque(BanqueId idBanque) {
        this.idBanque = idBanque;
    }

}
