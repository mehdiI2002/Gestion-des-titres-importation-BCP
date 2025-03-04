package org.gestiondestitresimportationbcp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BanqueId implements Serializable {
    private Long codeBank;
    private Long numEnregistrement;
    public BanqueId() {
    }

    public BanqueId(Long codeBank, Long numEnregistrement) {

        this.codeBank= codeBank;
        this.numEnregistrement = numEnregistrement;
    }



    public Long getNumEnregistrement() {
        return numEnregistrement;
    }

    public void setNumEnregistrement(Long numEnregistrement) {
        this.numEnregistrement = numEnregistrement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BanqueId banqueId = (BanqueId) o;
        return Objects.equals(codeBank, banqueId.codeBank) &&
                Objects.equals(numEnregistrement, banqueId.numEnregistrement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBank, numEnregistrement);
    }

    public Long getCodeBank() {
        return codeBank;
    }
}