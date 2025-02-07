package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Banque {
    @Id
    private Long codeBanque;
    private long  guichet;
    private long localite;
}
