package org.gestiondestitresimportationbcp.repositories;

import org.gestiondestitresimportationbcp.entities.MarchandiseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarchandiseRepository extends JpaRepository<MarchandiseInfo,Long> {
}
