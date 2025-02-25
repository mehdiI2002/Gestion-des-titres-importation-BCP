package org.gestiondestitresimportationbcp.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TitreImportationId implements Serializable {
    private Long numEnregistrement;
    private Long numeroMessage;

    public TitreImportationId() {}
    public TitreImportationId(Long numEnregistrement, Long numeroMessage) {
        this.numEnregistrement = numEnregistrement;
        this.numeroMessage = numeroMessage;
    }

    // Getters and setters
    public Long getNumEnregistrement() {
        return numEnregistrement;
    }

    public void setNumEnregistrement(Long numEnregistrement) {
        this.numEnregistrement = numEnregistrement;
    }

    public Long getNumeroMessage() {
        return numeroMessage;
    }

    public void setNumeroMessage(Long numeroMessage) {
        this.numeroMessage = numeroMessage;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitreImportationId that = (TitreImportationId) o;
        return Objects.equals(numEnregistrement, that.numEnregistrement) &&
                Objects.equals(numeroMessage, that.numeroMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEnregistrement, numeroMessage);
    }
}
