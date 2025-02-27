package org.gestiondestitresimportationbcp.repositories;

import org.gestiondestitresimportationbcp.entities.Fichier;
import org.gestiondestitresimportationbcp.models.FichierID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichierRepository  extends JpaRepository<Fichier, FichierID> {
}
