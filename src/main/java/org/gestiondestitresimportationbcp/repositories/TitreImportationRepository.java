package org.gestiondestitresimportationbcp.repositories;

import org.gestiondestitresimportationbcp.entities.TitreImportation;
import org.gestiondestitresimportationbcp.models.TitreImportationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface TitreImportationRepository extends JpaRepository<TitreImportation, TitreImportationId> {
    Optional<TitreImportation> findByIdNumEnregistrementAndIdNumeroMessage(@Param("numEnregistrement") Long numEnregistrement, @Param("numeroMessage") Long numeroMessage);

   TitreImportation findByIdNumeroMessage(Long numeroMessage);
    @Query("SELECT t FROM TitreImportation t WHERE t.etat = 'non traiter'")
    List<TitreImportation> findNonTraites();

}
