package org.gestiondestitresimportationbcp.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class FichierID {
    private Long numeroMessage ;
    private String nom ;

    public FichierID() {
    }

    public FichierID(Long numeroMessage, String nom) {
        this.numeroMessage = numeroMessage;
        this.nom = nom;
    }

    public Long getNumeroMessage() {
        return numeroMessage;
    }

    public String getNom() {
        return nom;
    }

}
