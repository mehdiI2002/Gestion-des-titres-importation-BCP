package org.gestiondestitresimportationbcp.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class TitreFICId {
    private Long numeroMessage ;
    private Long numEnregistrement ;
    public TitreFICId(Long numeroMessage, Long numEnregistrement) {
        this.numeroMessage = numeroMessage;
        this.numEnregistrement = numEnregistrement;
    }

    public Long getNumEnregistrement() {
        return numEnregistrement;
    }

    public TitreFICId() {
    }

    public Long getNumeroMessage() {
        return numeroMessage;
    }
}
