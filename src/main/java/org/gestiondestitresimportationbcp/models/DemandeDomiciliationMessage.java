package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.entities.Operator;
import org.gestiondestitresimportationbcp.entities.TitreImportation;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DemandeDomiciliationMessage {

    @XmlElement(name = "HeaderMessage")
    private Message headerMessage;

   @XmlElement(name = "Operateur")
    private Operator operateur;

    @XmlElement(name = "Titre")
    private TitreImportation titre;

    /*@XmlElement(name = "Banque")
    private Banque banque;



    // Cet élément est défini avec le préfixe pn, donc il faut préciser le namespace
    @XmlElement(name = "Marchandise", namespace = "http://portnet.ma/DemandeDomiciliation")
    private Marchandise marchandise;
*/

    public Message getHeaderMessage() {
        return headerMessage;
    }

    public Operator getOperateur() {
        return operateur;
    }

    public TitreImportation getTitre() {
        return titre;
    }

}

