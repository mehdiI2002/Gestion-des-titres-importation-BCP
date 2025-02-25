package org.gestiondestitresimportationbcp.repositories;

import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.models.TitreImportationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitreImportationRepository extends JpaRepository<TitreImportation, TitreImportationId> {
    Optional<TitreImportation> findByIdNumEnregistrementAndIdNumeroMessage(Long numEnregistrement, Long numeroMessage);
}
