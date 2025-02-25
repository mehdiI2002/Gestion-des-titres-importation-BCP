package org.gestiondestitresimportationbcp.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class OperatorId {
    private long  numIdentificationOperator;
 Long numEnregistrementOperator;
    public OperatorId() {
    }
    public OperatorId(long numIdentificationOperator, Long numEnregistrement) {
       this. numIdentificationOperator = numIdentificationOperator;
        this.numEnregistrementOperator= numEnregistrement;
    }
    public void setNumIdentification(long numIdentification) {
        numIdentificationOperator = numIdentification;
    }

    public void setNumEnregistrement(Long numEnregistrement) {
        this.numEnregistrementOperator= numEnregistrement;
    }

    public long getNumIdentification() {
        return numIdentificationOperator;
    }

    public Long getNumEnregistrement() {
        return numEnregistrementOperator;
    }
}
