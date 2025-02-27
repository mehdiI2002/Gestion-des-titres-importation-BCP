package org.gestiondestitresimportationbcp.repositories;


import org.gestiondestitresimportationbcp.entities.TitreFIC;
import org.gestiondestitresimportationbcp.models.TitreFICId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitreFICRepository  extends JpaRepository<TitreFIC,TitreFICId> {
}
