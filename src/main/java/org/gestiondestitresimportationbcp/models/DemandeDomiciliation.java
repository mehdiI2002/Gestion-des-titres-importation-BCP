package org.gestiondestitresimportationbcp.models;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "DemandeDomiciliation", namespace = "http://portnet.ma/DemandeDomiciliation")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DemandeDomiciliation {
    @XmlElement(name = "DemandeDomiciliationMessage")
    private DemandeDomiciliationMessage demandeDomiciliationMessage;
    public DemandeDomiciliationMessage getDemandeDomiciliationMessage() {
        return demandeDomiciliationMessage;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class PaysProvenanceInfo {
        @Id
        private  Long  id ;
        private String  PaysProvenance;

    }
}